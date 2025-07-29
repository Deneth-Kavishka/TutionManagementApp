package com.project.tuitionmanagementapp.models

data class Parent(
    val id: String = "",
    val fatherName: String = "",
    val motherName: String = "",
    val fatherPhone: String = "",
    val motherPhone: String = "",
    val fatherEmail: String = "",
    val motherEmail: String = "",
    val fatherOccupation: String = "",
    val motherOccupation: String = "",
    val emergencyContact: String = "",
    val emergencyContactName: String = "",
    val address: String = "",
    val relationshipToStudent: String = "", // Father, Mother, Guardian
    val preferredContactMethod: String = "", // Phone, Email, SMS
    val preferredContactPerson: String = "" // Father, Mother, Emergency Contact
)
