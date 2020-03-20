package sample.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_products.progressBar
import kotlinx.android.synthetic.main.activity_products.recyclerView
import sample.R
import sample.di.Injector
import sample.domain.model.Product
import sample.presentation.product.ProductsView

class ProductsActivity : BaseActivity(), ProductsView {

    private val presenter = Injector.provideProductsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProducts(products: List<Product>) {
        if (recyclerView.adapter == null) {
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@ProductsActivity)
                adapter = ProductsAdapter(products)
            }
        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showError(error: Throwable) {
        super.showError(error)
        hideLoading()
    }
}
