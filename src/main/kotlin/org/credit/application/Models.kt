package org.credit.application


data class CreditResult(
    val success: Boolean,
    val reason: String = ""
)

data class CreditApplication(
    val member: Member,
    val product: Product
)

data class Member(
    val name: String,
    val age: Int,
    val income: Int
)

data class Product(
    val name: String,
    val value: Int
)