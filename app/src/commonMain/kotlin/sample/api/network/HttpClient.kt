package sample.api.network

import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.post
import sample.data.products.ProductsResponse
import sample.data.user.LoginResponse
import io.ktor.client.HttpClient as KtorHttpClient

class HttpClient {

    companion object {
        private const val loginUrl = "https://demo9748122.mockable.io/login"
        private const val productsUrl = "https://demo9748122.mockable.io/products"
    }

    private val httpClient = KtorHttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun doLogin(): LoginResponse = httpClient.post(loginUrl)
    suspend fun getProducts(): ProductsResponse = httpClient.get<ProductsResponse>(productsUrl)
}