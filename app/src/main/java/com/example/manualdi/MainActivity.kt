package com.example.manualdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.manualdi.ui.main.MainFragment
import com.example.manualdi.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var activityScopedViewModel: LoginViewModel
    private lateinit var applicationScopedLoginViewModel: LoginViewModel

    private lateinit var appContainer: AppContainer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }


        /*
        * Gets LoginViewModelFactory from the application instance of AppContainer
        * to create a new LoginViewModel instance
        * */
        appContainer = (application as MyApplication).appContainer

        activityScopedViewModel = LoginViewModel(appContainer.userRepository)
        applicationScopedLoginViewModel = appContainer.loginViewModelFactory.create()

    }


    override fun onDestroy() {
        // Removing the instance of loginContainer in the AppContainer
        appContainer.loginContainer = null

        super.onDestroy()
    }
}