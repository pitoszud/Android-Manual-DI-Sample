package com.example.manualdi

import LoginViewModelFactory
import com.example.manualdi.domain.LoginUserData

class LoginContainer(val userRepository: UserRepository) {

    val loginData = LoginUserData()

    val loginViewModelFactory = LoginViewModelFactory(userRepository)
}
