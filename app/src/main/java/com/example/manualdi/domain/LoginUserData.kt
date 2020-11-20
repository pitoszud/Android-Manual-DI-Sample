package com.example.manualdi.domain

data class LoginUserData(
    val userId: String = "",
    val userName: String = "",
    val isLoggedIn: Boolean = false
)