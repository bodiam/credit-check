package org.credit.rule.rules

import org.credit.application.CreditApplication
import org.credit.rule.Rule
import org.credit.rule.RuleResult
import java.lang.RuntimeException

class AlwaysThrowsExceptionRule : Rule {

    override fun execute(application: CreditApplication): RuleResult {
        println("Executing AlwaysThrowsExceptionRule")

        throw RuntimeException("This rule is throwing an exception on purpose")
    }
}