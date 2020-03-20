package sample.presentation.login

import sample.domain.model.User
import sample.presentation.BaseView

interface LoginView : BaseView {
    fun showLoginScreen()
    fun showLoggedScreen(user: User)
    fun showLoading()
    fun hideLoading()
    fun navigateToGlobalPosition()
}