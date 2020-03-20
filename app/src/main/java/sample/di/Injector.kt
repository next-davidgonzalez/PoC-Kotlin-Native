package sample.di

import sample.api.ImageLoader
import sample.api.logger.CustomLogger
import sample.api.network.HttpClient
import sample.data.products.ProductsRepository
import sample.data.user.UserRepository
import sample.domain.applicationDispatcher
import sample.presentation.login.LoginPresenter
import sample.presentation.login.LoginView
import sample.presentation.product.ProductsPresenter
import sample.presentation.product.ProductsView
import sample.utils.AndroidLogger

object Injector {

    private val userRepository by lazy { UserRepository(httpClient) }
    private val productsRepository by lazy { ProductsRepository(httpClient) }
    private val httpClient by lazy { HttpClient() }
    private val androidLogger by lazy { AndroidLogger() }
    private val imageLoader by lazy { ImageLoader() }

    fun provideLoginPresenter(view: LoginView): LoginPresenter {
        return LoginPresenter(view, userRepository, applicationDispatcher)
    }

    fun provideProductsPresenter(view: ProductsView): ProductsPresenter {
        return ProductsPresenter(view, productsRepository, applicationDispatcher)
    }

    fun provideAndroidLogger(): CustomLogger {
        return androidLogger
    }

    fun provideImageLoader(): ImageLoader {
        return imageLoader
    }

}