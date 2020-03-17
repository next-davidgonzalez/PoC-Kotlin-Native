package sample

import sample.api.HttpClient
import sample.data.UserRepository

class Application : android.app.Application() {

    val userRepository: UserRepository by lazy { UserRepository(HttpClient()) }
}