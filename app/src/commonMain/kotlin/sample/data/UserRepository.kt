package sample.data

import sample.api.HttpClient
import sample.api.Logger
import sample.domain.User
import toUserModel

class UserRepository(
    private val httpClient: HttpClient
) : Repository {

    override val user: User? = null

    override suspend fun doLogin(): User {
        Logger.log("Invoking doLogin")
        return httpClient.doLogin().toUserModel()
    }
}