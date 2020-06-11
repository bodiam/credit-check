package org.credit.rule.rules

import org.credit.application.CreditApplication
import org.credit.rule.Rule
import org.credit.rule.RuleResult


class ProductPurchaseRule : Rule {
    override fun execute(application: CreditApplication): RuleResult {

        val assessment = application.product.value < application.member.income * 4

        return RuleResult(
            ruleName = "product purchase",
            result = assessment,
            details = "Purchases can only be made against 1/100th of the income"
        )
    }
}