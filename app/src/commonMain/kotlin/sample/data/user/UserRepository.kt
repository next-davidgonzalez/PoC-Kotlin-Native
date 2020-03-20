package sample.data.user

import sample.api.network.HttpClient
import sample.api.logger.Logger
import sample.domain.model.User
import sample.domain.toModel

class UserRepository(
    private val httpClient: HttpClient
) : Repository {

    override val user: User? = null

    override suspend fun doLogin(): User {
        Logger.log("Invoking doLogin")
        return httpClient.doLogin().toModel()
    }
}