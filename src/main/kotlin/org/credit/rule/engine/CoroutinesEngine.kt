package org.credit.rule.engine

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.credit.application.CreditApplication
import org.credit.application.CreditResult
import org.credit.rule.rules.AlwaysThrowsExceptionRule
import org.credit.rule.rules.CreditHistoryRule
import org.credit.rule.rules.CriminalRecordRule
import org.credit.rule.rules.ProductPurchaseRule

class CoroutinesEngine : Engine {

    override fun execute(creditApplication: CreditApplication): CreditResult = runBlocking {

        val one = async { CreditHistoryRule().execute(creditApplication) }
        val two = async { CriminalRecordRule().execute(creditApplication) }
        val three = async { ProductPurchaseRule().execute(creditApplication) }
//        val four = async { AlwaysThrowsExceptionRule().execute(creditApplication) }

        val results = listOf(one.await(), two.await(), three.await())

        val result = results.all { it.result }

        CreditResult(result)
    }
}