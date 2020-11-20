
import com.example.manualdi.UserRepository
import com.example.manualdi.viewmodel.LoginViewModel


interface Factory<T> {
    fun create(): T
}

// Factory for LoginViewModel.
// Since LoginViewModel depends on UserRepository, in order to create instances of
// LoginViewModel, you need an instance of UserRepository that you pass as a parameter.

class LoginViewModelFactory(private val userRepository: UserRepository) : Factory<LoginViewModel> {
    override fun create(): LoginViewModel {
        return LoginViewModel(userRepository)
    }
}
