package sample.presentation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sample.data.UserRepository
import kotlin.coroutines.CoroutineContext

class LoginPresenter(
    private val view: LoginView,
    private val repository: UserRepository,
    coroutineContext: CoroutineContext
) : BasePresenter(view, coroutineContext) {

    override fun onCreate() {
        val user = repository.user
        if (user != null) {
            view.showLoggedScreen(user)
        } else {
            view.showLoginScreen()
        }
    }

    fun doLogin() {
        launch {
            withContext(Dispatchers.Main) {
                view.showLoading()
            }

            val user = repository.doLogin()

            withContext(Dispatchers.Main) {
                view.hideLoading()
                view.showLoggedScreen(user)
                view.navigateToGlobalPosition()
            }
        }
    }
}
