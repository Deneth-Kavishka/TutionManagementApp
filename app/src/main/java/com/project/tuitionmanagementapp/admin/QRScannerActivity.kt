package com.project.tuitionmanagementapp.admin

import android.Manifest
import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.ImageFormat
import android.graphics.Point
import android.graphics.SurfaceTexture
import android.hardware.camera2.*
import android.media.ImageReader
import android.os.*
import android.util.Log
import android.util.Size
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.*
import com.google.zxing.common.HybridBinarizer
import com.project.tuitionmanagementapp.R
import java.util.*
import java.util.concurrent.Executors
import android.hardware.camera2.CameraCharacteristics
import kotlin.math.abs

class QRScannerActivity : AppCompatActivity(), SurfaceHolder.Callback {

    // UI Components
    private lateinit var surfaceView: SurfaceView
    private lateinit var btnBack: ImageView
    private lateinit var btnFlashlight: ImageView
    private lateinit var scanLine: View
    private lateinit var scanSuccess: ImageView

    // Camera Components
    private var cameraManager: CameraManager? = null
    private var cameraDevice: CameraDevice? = null
    private var captureSession: CameraCaptureSession? = null
    private var imageReader: ImageReader? = null

    // ZXing Components
    private val zxingReader = MultiFormatReader()
    private val zxingHints = mapOf(
        DecodeHintType.TRY_HARDER to true,
        DecodeHintType.POSSIBLE_FORMATS to listOf(BarcodeFormat.QR_CODE)
    )

    // Threading
    private val cameraExecutor = Executors.newSingleThreadExecutor()
    private lateinit var backgroundHandler: Handler

    // State Variables
    private var isFlashlightOn = false
    private var isScanning = true
    private var optimalPreviewSize: Size? = null
    private var lastProcessedTime = 0L

    companion object {
        private const val TAG = "QRScanner"
        private const val CAMERA_PERMISSION_REQUEST_CODE = 1001
        private const val SCAN_ANIMATION_DURATION = 1500L
        private const val SUCCESS_FEEDBACK_DURATION = 1000L
        private const val PROCESSING_INTERVAL_MS = 500L
    }

    // Camera State Callback
    private val stateCallback = object : CameraDevice.StateCallback() {
        override fun onOpened(camera: CameraDevice) {
            cameraDevice = camera
            createCameraPreviewSession()
            startScanAnimation()
        }

        override fun onDisconnected(camera: CameraDevice) {
            camera.close()
            cameraDevice = null
        }

        override fun onError(camera: CameraDevice, error: Int) {
            camera.close()
            cameraDevice = null
            showError("Camera error: $error")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_scanner)

        // Initialize background handler
        val handlerThread = HandlerThread("CameraBackground").apply { start() }
        backgroundHandler = Handler(handlerThread.looper)

        // Initialize ZXing reader
        zxingReader.setHints(zxingHints)

        initializeViews()
        setupClickListeners()
        checkCameraPermission()
    }

    private fun initializeViews() {
        surfaceView = findViewById(R.id.surfaceView)
        btnBack = findViewById(R.id.btnBack)
        btnFlashlight = findViewById(R.id.btnFlashlight)
        scanLine = findViewById(R.id.scanLine)
        scanSuccess = findViewById(R.id.scanSuccess)

        surfaceView.holder.addCallback(this)
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener { finish() }
        btnFlashlight.setOnClickListener { toggleFlashlight() }
    }

    private fun checkCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                setupCamera()
            }
            ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) -> {
                Toast.makeText(this, "Camera permission is required", Toast.LENGTH_LONG).show()
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
            }
            else -> {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupCamera()
            } else {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    private fun setupCamera() {
        try {
            cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
            checkFlashlightAvailability()
        } catch (e: Exception) {
            Log.e(TAG, "Camera setup failed", e)
            showError("Camera setup failed")
            finish()
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        openCamera()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // No-op
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        closeCamera()
    }

    private fun openCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            return
        }

        try {
            val cameraId = getCameraId()
            setupOptimalPreviewSize(cameraId)
            cameraManager?.openCamera(cameraId, stateCallback, backgroundHandler)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to open camera", e)
            showError("Failed to open camera")
        }
    }

    private fun getCameraId(): String {
        return cameraManager?.cameraIdList?.firstOrNull { id ->
            val characteristics = cameraManager?.getCameraCharacteristics(id)
            characteristics?.get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_BACK
        } ?: throw IllegalStateException("No back camera found")
    }

    private fun setupOptimalPreviewSize(cameraId: String): Size {
        val characteristics = cameraManager!!.getCameraCharacteristics(cameraId)
        val map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)!!

        // Get the device's screen aspect ratio
        val display = windowManager.defaultDisplay
        val realSize = Point()
        display.getRealSize(realSize)
        val screenRatio = realSize.y.toFloat() / realSize.x.toFloat()

        // Get all available preview sizes and sort by area (descending)
        val previewSizes = map.getOutputSizes(SurfaceTexture::class.java)
            .sortedByDescending { it.width * it.height }

        // Find the size that best matches the screen aspect ratio
        return previewSizes.maxByOrNull {
            val previewRatio = it.height.toFloat() / it.width.toFloat()
            abs(previewRatio - screenRatio)
        } ?: previewSizes[0] // Fallback to largest size
    }

    private fun createCameraPreviewSession() {
        try {
            val surface = surfaceView.holder.surface
            val cameraId = getCameraId()
            val previewSize = setupOptimalPreviewSize(cameraId)

            Log.d(TAG, "Using preview size: ${previewSize.width}x${previewSize.height}")

            // Set fixed size for the surface
            surfaceView.holder.setFixedSize(previewSize.width, previewSize.height)

            // Create ImageReader with optimal size
            imageReader = ImageReader.newInstance(
                previewSize.width,
                previewSize.height,
                ImageFormat.YUV_420_888,
                2
            ).apply {
                setOnImageAvailableListener({ reader ->
                    try {
                        reader.acquireLatestImage()?.use { image ->
                            processImage(image)
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Image processing error", e)
                    }
                }, backgroundHandler)
            }

            // Prepare the capture request
            val previewRequestBuilder = cameraDevice!!.createCaptureRequest(
                CameraDevice.TEMPLATE_PREVIEW
            ).apply {
                addTarget(surface)
                addTarget(imageReader!!.surface)

                // Auto-focus and auto-exposure for better QR detection
                set(CaptureRequest.CONTROL_AF_MODE,
                    CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE)
                set(CaptureRequest.CONTROL_AE_MODE,
                    CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH)
            }

            // Create the capture session
            cameraDevice?.createCaptureSession(
                listOf(surface, imageReader!!.surface),
                object : CameraCaptureSession.StateCallback() {
                    override fun onConfigured(session: CameraCaptureSession) {
                        try {
                            captureSession = session
                            session.setRepeatingRequest(
                                previewRequestBuilder.build(),
                                null,
                                backgroundHandler
                            )
                        } catch (e: CameraAccessException) {
                            Log.e(TAG, "Failed to start preview", e)
                        }
                    }

                    override fun onConfigureFailed(session: CameraCaptureSession) {
                        showError("Camera configuration failed")
                    }
                },
                backgroundHandler
            )
        } catch (e: Exception) {
            Log.e(TAG, "Failed to create preview session", e)
            showError("Camera session failed")
        }
    }

    private fun processImage(image: android.media.Image) {
        try {
            if (!isScanning) return

            // Limit processing rate to prevent overload
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastProcessedTime < PROCESSING_INTERVAL_MS) {
                return
            }
            lastProcessedTime = currentTime

            // Convert Image to ZXing-compatible format
            val yuvData = image.planes[0].buffer
            val width = image.width
            val height = image.height
            val source = PlanarYUVLuminanceSource(
                yuvData.array(),
                width,
                height,
                0, 0, // No cropping
                width,
                height,
                false // Not rotated
            )

            val binaryBitmap = BinaryBitmap(HybridBinarizer(source))

            try {
                val result = zxingReader.decodeWithState(binaryBitmap)
                result.text?.let { qrContent ->
                    isScanning = false
                    handleQRCodeResult(qrContent)
                }
            } catch (e: NotFoundException) {
                // QR code not found in this frame - normal during scanning
            } catch (e: Exception) {
                Log.e(TAG, "ZXing decoding error", e)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Image processing error", e)
        } finally {
            image.close()
        }
    }

    private fun handleQRCodeResult(qrContent: String) {
        runOnUiThread {
            showSuccessFeedback()
            vibrateDevice(200)

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, StudentDetailsActivity::class.java).apply {
                    putExtra("student_id", qrContent)
                    putExtra("scanned_from_qr", true)
                }
                startActivity(intent)
                finish()
            }, SUCCESS_FEEDBACK_DURATION)
        }
    }

    private fun toggleFlashlight() {
        try {
            val cameraId = getCameraId()
            val characteristics = cameraManager?.getCameraCharacteristics(cameraId)
            val hasFlash = characteristics?.get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true

            if (hasFlash) {
                isFlashlightOn = !isFlashlightOn
                updateFlashlightState()
            }
        } catch (e: Exception) {
            showError("Flash error")
        }
    }

    private fun updateFlashlightState() {
        try {
            val previewRequestBuilder = cameraDevice?.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW).apply {
                this?.addTarget(surfaceView.holder.surface)
                this?.addTarget(imageReader?.surface!!)
                this?.set(
                    CaptureRequest.FLASH_MODE,
                    if (isFlashlightOn) CaptureRequest.FLASH_MODE_TORCH else CaptureRequest.FLASH_MODE_OFF
                )
                runOnUiThread {
                    btnFlashlight.setImageResource(
                        if (isFlashlightOn) R.drawable.ic_flashlight_on else R.drawable.ic_flashlight_off
                    )
                }
            }

            previewRequestBuilder?.build()?.let { request ->
                captureSession?.setRepeatingRequest(request, null, backgroundHandler)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to update flashlight", e)
        }
    }

    private fun checkFlashlightAvailability() {
        try {
            val cameraId = getCameraId()
            val characteristics = cameraManager?.getCameraCharacteristics(cameraId)
            val hasFlash = characteristics?.get(CameraCharacteristics.FLASH_INFO_AVAILABLE) ?: false
            runOnUiThread {
                btnFlashlight.visibility = if (hasFlash) View.VISIBLE else View.GONE
            }
        } catch (e: Exception) {
            runOnUiThread {
                btnFlashlight.visibility = View.GONE
            }
        }
    }

    private fun startScanAnimation() {
        runOnUiThread {
            scanLine.visibility = View.VISIBLE
            ValueAnimator.ofFloat(0f, 1f).apply {
                duration = SCAN_ANIMATION_DURATION
                interpolator = LinearInterpolator()
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
                addUpdateListener { animation ->
                    val value = animation.animatedValue as Float
                    scanLine.translationY = (value * 250) - 125 // Adjust for your frame size
                }
                start()
            }
        }
    }

    private fun showSuccessFeedback() {
        runOnUiThread {
            scanSuccess.scaleX = 0f
            scanSuccess.scaleY = 0f
            scanSuccess.visibility = View.VISIBLE

            scanSuccess.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(300)
                .setInterpolator(OvershootInterpolator())
                .start()
        }
    }

    private fun vibrateDevice(durationMs: Long) {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator?.vibrate(VibrationEffect.createOneShot(durationMs, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            @Suppress("DEPRECATION")
            vibrator?.vibrate(durationMs)
        }
    }

    private fun showError(message: String) {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }

    private fun closeCamera() {
        try {
            captureSession?.close()
            cameraDevice?.close()
            imageReader?.close()
        } catch (e: Exception) {
            Log.e(TAG, "Error closing camera", e)
        } finally {
            captureSession = null
            cameraDevice = null
            imageReader = null
        }
    }

    override fun onResume() {
        super.onResume()
        if (surfaceView.holder.surface.isValid) {
            openCamera()
        }
        isScanning = true
    }

    override fun onPause() {
        super.onPause()
        closeCamera()
    }

    override fun onDestroy() {
        super.onDestroy()
        closeCamera()
        backgroundHandler.looper.quitSafely()
    }
}