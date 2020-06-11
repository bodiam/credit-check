package org.credit.rule.engine

import org.credit.application.CreditApplication
import org.credit.application.CreditResult
import org.credit.rule.rules.CreditHistoryRule
import org.credit.rule.rules.CriminalRecordRule
import org.credit.rule.rules.ProductPurchaseRule

class SequentialEngine : Engine {

    private val rules = listOf(
        CreditHistoryRule(), CriminalRecordRule(), ProductPurchaseRule()
    )

    override fun execute(creditApplication: CreditApplication): CreditResult {

        return CreditResult(
            success = rules.all { rule ->
                val ruleResult = rule.execute(creditApplication)

                println("${ruleResult.ruleName} produced ${ruleResult.result}")

                ruleResult.result
            }
        )
    }
}