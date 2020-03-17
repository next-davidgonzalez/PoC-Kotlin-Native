package sample.data

import sample.domain.User

interface Repository {
    val user: User?
    suspend fun doLogin(): User
}