package sample.data

import sample.api.HttpClient
import sample.domain.User
import toUserModel

class UserRepository(
    private val httpClient: HttpClient
) : Repository {

    override val user: User? = null

    override suspend fun doLogin(): User {
        return httpClient.doLogin().toUserModel()
    }
}