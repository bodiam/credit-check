package org.credit.rule

import org.credit.application.CreditApplication
import org.credit.application.CreditResult

interface Rule {
    fun execute(application: CreditApplication): RuleResult
}

data class RuleResult(
    val ruleName: String,
    val result: Boolean,
    val details: String
)