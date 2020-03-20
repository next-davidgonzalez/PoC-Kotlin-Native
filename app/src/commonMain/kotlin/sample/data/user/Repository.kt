package sample.data.user

import sample.domain.model.User

interface Repository {
    val user: User?
    suspend fun doLogin(): User
}