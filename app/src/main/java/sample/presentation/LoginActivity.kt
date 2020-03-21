package sample.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.loginButton
import kotlinx.android.synthetic.main.activity_main.passwordTextInputLayout
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.userImageView
import kotlinx.android.synthetic.main.activity_main.userNameTextView
import kotlinx.android.synthetic.main.activity_main.userTextInputLayout
import sample.R
import sample.di.Injector
import sample.domain.model.User
import sample.presentation.login.LoginView

class LoginActivity : BaseActivity(), LoginView {

    private val presenter = Injector.provideLoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoginScreen() {
        logger.log("Show login screen")
        loginButton.setOnClickListener { presenter.doLogin() }
        userImageView.visibility = View.GONE
        userNameTextView.visibility = View.GONE
        userTextInputLayout.visibility = View.VISIBLE
        passwordTextInputLayout.visibility = View.VISIBLE

    }

    override fun showLoggedScreen(user: User) {
        logger.log("Show logged screen")
        loginButton.setOnClickListener { navigateToGlobalPosition() }
        userImageView.visibility = View.VISIBLE
        userNameTextView.visibility = View.VISIBLE
        userTextInputLayout.visibility = View.GONE
        passwordTextInputLayout.visibility = View.GONE
        userNameTextView.text = "¡Hola, ${user.name}!"
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun navigateToGlobalPosition() {
        startActivity(Intent(this, ProductsActivity::class.java))
    }

    override fun showError(error: Throwable) {
        super.showError(error)
        hideLoading()
    }
}