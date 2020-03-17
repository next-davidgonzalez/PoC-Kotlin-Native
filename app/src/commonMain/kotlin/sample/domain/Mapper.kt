import sample.data.LoginResponse
import sample.domain.User

fun LoginResponse.toUserModel() = User(name, token)