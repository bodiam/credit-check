package org.credit.rule.rules

import org.credit.application.CreditApplication
import org.credit.rule.Rule
import org.credit.rule.RuleResult
import org.credit.rule.rules.credithistory.CreditHistoryDatabase

class CreditHistoryRule(private val creditHistoryDatabase: CreditHistoryDatabase = CreditHistoryDatabase()) : Rule {

    override fun execute(application: CreditApplication): RuleResult {

        println("Executing CreditHistoryRule")

        val reliable = creditHistoryDatabase.findAll(application.member.name).sumBy { it.score } > 500

        return RuleResult(
            ruleName = "product purchase",
            result = reliable,
            details = "Purchases can only be made against 1/100th of the income"
        )
    }
}