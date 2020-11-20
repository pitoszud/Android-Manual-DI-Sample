package com.example.manualdi

import LoginViewModelFactory
import com.example.manualdi.data.UserLocalDataSource
import com.example.manualdi.data.UserRemoteDataSource
import com.example.manualdi.service.LoginService
import retrofit2.Retrofit


// AppContainer can now provide instances of LoginViewModel with LoginViewModelFactory
// AppContainer can also contain LoginContainer
class AppContainer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://example.com")
        .build()
        .create(LoginService::class.java)

    private val remoteDataSource = UserRemoteDataSource(retrofit)
    private val localDataSource = UserLocalDataSource()

    val userRepository = UserRepository(localDataSource, remoteDataSource)

    val loginViewModelFactory = LoginViewModelFactory(userRepository)

    // LoginContainer will be null when the user is NOT in the login flow
    var loginContainer: LoginContainer? = null

}
