package sample.presentation.product

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sample.data.products.ProductsRepository
import sample.presentation.BasePresenter
import kotlin.coroutines.CoroutineContext

class ProductsPresenter(
    private val view: ProductsView,
    private val repository: ProductsRepository,
    coroutineContext: CoroutineContext
) : BasePresenter(view, coroutineContext) {

    override fun onCreate() {
        launch {
            withContext(Dispatchers.Main) {
                view.showLoading()
            }

            val products = repository.getProducts()

            withContext(Dispatchers.Main) {
                view.hideLoading()
                view.showProducts(products)
            }
        }
    }
}
