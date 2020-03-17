package sample.presentation

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter(
    private val baseView: BaseView,
    private val presenterContext: CoroutineContext
) : CoroutineScope {
    private val job = Job()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        GlobalScope.launch {
            withContext(Dispatchers.Main) { baseView.showError(throwable) }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = presenterContext + job + exceptionHandler

    abstract fun onCreate()

    open fun onDestroy() {
        job.cancel()
    }
}
