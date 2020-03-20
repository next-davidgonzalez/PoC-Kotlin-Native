package sample.data.products

import sample.api.network.HttpClient
import sample.api.logger.Logger
import sample.domain.model.Product
import sample.domain.toModel

class ProductsRepository(
    private val httpClient: HttpClient
) : Repository {

    override suspend fun getProducts(): List<Product> {
        Logger.log("Invoking getProducts")
        return httpClient.getProducts().toModel()
    }
}