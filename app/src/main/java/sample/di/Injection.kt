package sample.di

import sample.api.CustomLogger
import sample.api.HttpClient
import sample.data.UserRepository
import sample.domain.applicationDispatcher
import sample.presentation.LoginPresenter
import sample.presentation.LoginView
import sample.utils.AndroidLogger

object Injection {

    private val userRepository by lazy { UserRepository(httpClient) }
    private val httpClient by lazy { HttpClient() }
    private val androidLogger by lazy { AndroidLogger() }

    fun provideLoginPresenter(loginView: LoginView): LoginPresenter {
        return LoginPresenter(loginView, userRepository, applicationDispatcher)
    }

    fun provideAndroidLogger(): CustomLogger {
        return androidLogger
    }

}