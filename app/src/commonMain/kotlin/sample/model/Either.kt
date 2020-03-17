package sample.model

sealed class Either<out F, out S> {

    class Failure<out Failure>(val failure: Failure) : Either<Failure, Nothing>()
    class Success<out Success>(val success: Success) : Either<Nothing, Success>()

    inline fun <T> choose(failed: (F) -> T, succeeded: (S) -> T): T {
        return when (this) {
            is Failure -> failed(failure)
            is Success -> succeeded(success)
        }
    }
}
