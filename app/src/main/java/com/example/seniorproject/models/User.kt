package com.example.seniorproject.models


/**
 * A data model class for User with required fields.
 */
// START
data class User(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val image: String = "",
    val mobile: Long = 0,
    val gender: String = "",
    val profileCompleted: Int = 0)
// END