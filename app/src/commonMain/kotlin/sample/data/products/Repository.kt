package sample.data.products

import sample.domain.model.Product

interface Repository {
    suspend fun getProducts(): List<Product>
}