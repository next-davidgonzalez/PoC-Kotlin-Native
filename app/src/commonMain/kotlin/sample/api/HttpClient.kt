package sample.api

import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.post
import sample.data.LoginResponse
import io.ktor.client.HttpClient as KtorHttpClient

class HttpClient {

    companion object {
        private const val loginUrl = "https://demo9748122.mockable.io/login"
    }

    private val httpClient = KtorHttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun doLogin(): LoginResponse = httpClient.post(loginUrl)
}