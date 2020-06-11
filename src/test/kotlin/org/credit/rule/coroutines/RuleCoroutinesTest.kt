package org.credit.rule.coroutines

import kotlinx.coroutines.*
import org.credit.application.CreditApplication
import org.credit.application.Member
import org.credit.application.Product
import org.credit.rule.rules.CreditHistoryRule
import org.credit.rule.rules.CriminalRecordRule
import org.credit.rule.rules.ProductPurchaseRule
import kotlin.system.*

fun main() = runBlocking<Unit> {

    val application = CreditApplication(
        member = Member("Eric", 35, 100000),
        product = Product("Tesla Model S", 15000)
    )

    val one = async { delay(3000); CreditHistoryRule().execute(application) }
    val two = async { CriminalRecordRule().execute(application) }
    val three = async { ProductPurchaseRule().execute(application) }

    val results = listOf(one.await(), two.await(), three.await())

    val result = results.all { it.result }

    println("All rules executed, result was: $result")
}

