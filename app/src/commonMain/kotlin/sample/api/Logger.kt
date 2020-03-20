package sample.api

object Logger {

    private val loggerList = mutableListOf<CustomLogger>()

    fun add(logger: CustomLogger) {
        loggerList += logger
    }

    fun log(message: String) {
        loggerList.forEach { it.log(message) }
    }
}