package sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sample.di.Injector

open class BaseActivity : AppCompatActivity(), BaseView {

    val logger = Injector.provideAndroidLogger()

    override fun showError(error: Throwable) {
        logger.log(error.message.toString())
    }
}
