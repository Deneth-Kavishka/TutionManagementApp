package com.project.tuitionmanagementapp.common.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.tuitionmanagementapp.common.models.Student
import com.project.tuitionmanagementapp.repository.StudentRepository

class StudentViewModel : ViewModel() {

    private val repository = StudentRepository()

    fun getAllStudents(): LiveData<List<Student>> {
        return repository.fetchApprovedStudents()
    }

    fun getPendingRegistrations(): LiveData<List<Student>> {
        return repository.fetchPendingStudents()
    }

    fun approveStudent(studentId: String) {
        repository.approveStudentById(studentId)
    }

    fun deleteStudent(studentId: String) {
        repository.deleteStudentById(studentId)
    }
}
