package sample.domain

import sample.data.products.ProductsResponse
import sample.data.user.LoginResponse
import sample.domain.model.Account
import sample.domain.model.Card
import sample.domain.model.Product
import sample.domain.model.User

fun LoginResponse.toModel() = User(name)

fun ProductsResponse.toModel(): List<Product> {
    val accounts = accounts.map { Account(it.label, it.amount, it.currency, it.pan4) }
    val cards = cards.map { Card(it.label, it.pan4, it.cover) }
    return accounts + cards
}