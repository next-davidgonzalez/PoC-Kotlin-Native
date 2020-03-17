package sample.data

import kotlinx.serialization.Serializable

@Serializable
class LoginResponse(val name: String, val token: String)
