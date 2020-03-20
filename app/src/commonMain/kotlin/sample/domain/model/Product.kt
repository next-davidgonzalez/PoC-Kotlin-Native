package sample.domain.model

sealed class Product
class Account(val label: String, val amount: String, val currency: String, val pan4: String) : Product()
class Card(val label: String, val pan4: String, val cover: String) : Product()