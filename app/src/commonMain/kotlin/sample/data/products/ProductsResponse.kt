package sample.data.products

import kotlinx.serialization.Serializable

@Serializable
class ProductsResponse(val accounts: List<Account>, val cards: List<Card>)

@Serializable
class Account(val label: String, val amount: String, val currency: String, val pan4: String)

@Serializable
class Card(val label: String, val pan4: String, val cover: String)
