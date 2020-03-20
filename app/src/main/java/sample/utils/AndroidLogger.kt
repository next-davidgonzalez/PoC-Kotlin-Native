package sample.utils

import android.util.Log
import sample.api.CustomLogger
import sample.api.Logger

class AndroidLogger : CustomLogger {
    init {
        Logger.add(this)
    }

    override fun log(message: String) {
        Log.d("AndroidNativeBank", message)
    }
}