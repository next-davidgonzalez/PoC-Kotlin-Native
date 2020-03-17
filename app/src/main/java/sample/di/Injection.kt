package sample.di

import sample.api.HttpClient
import sample.data.UserRepository
import sample.domain.applicationDispatcher
import sample.presentation.LoginPresenter
import sample.presentation.LoginView
import kotlin.coroutines.CoroutineContext

object Injection {

    private fun provideCoroutineContext(): CoroutineContext {
        return applicationDispatcher
    }

    fun provideLoginPresenter(loginView: LoginView): LoginPresenter {
        return LoginPresenter(loginView, provideUserRepository(), provideCoroutineContext())
    }

    private fun provideUserRepository(): UserRepository {
        return UserRepository(provideHttpClient())
    }

    private fun provideHttpClient(): HttpClient {
        return HttpClient()
    }
}