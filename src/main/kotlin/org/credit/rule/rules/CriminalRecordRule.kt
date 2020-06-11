package org.credit.rule.rules

import org.credit.application.CreditApplication
import org.credit.rule.Rule
import org.credit.rule.RuleResult

class CriminalRecordRule : Rule {
    override fun execute(application: CreditApplication): RuleResult {

        val criminal = application.member.name == "Erik"

        return RuleResult(
            ruleName = "check criminal record",
            result = !criminal,
            details = "No criminal record found"
        )
    }
}