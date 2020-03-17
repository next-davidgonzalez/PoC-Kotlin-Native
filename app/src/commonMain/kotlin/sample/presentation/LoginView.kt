package sample.presentation

import sample.domain.User

interface LoginView : BaseView {
    fun showLoginScreen()
    fun showLoggedScreen(user: User)
    fun showLoading()
    fun hideLoading()
    fun navigateToGlobalPosition()
}