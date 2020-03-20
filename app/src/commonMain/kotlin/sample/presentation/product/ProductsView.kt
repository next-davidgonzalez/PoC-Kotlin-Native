package sample.presentation.product

import sample.domain.model.Product
import sample.presentation.BaseView

interface ProductsView : BaseView {
    fun showProducts(products: List<Product>)
    fun showLoading()
    fun hideLoading()
}