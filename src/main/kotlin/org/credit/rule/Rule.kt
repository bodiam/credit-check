package org.credit.rule

import org.credit.application.CreditApplication

interface Rule {
    fun execute(application: CreditApplication): RuleResult
}

data class RuleResult(
    val ruleName: String,
    val result: Boolean,
    val details: String
)