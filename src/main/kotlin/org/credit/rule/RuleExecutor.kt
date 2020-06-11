package org.credit.rule

import org.credit.application.CreditApplication
import org.credit.application.CreditResult
import org.credit.rule.engine.Engine
import org.credit.rule.engine.SequentialEngine

class RuleExecutor(private val engine: Engine = SequentialEngine()) {

    fun process(creditApplication: CreditApplication): CreditResult {
        return engine.execute(creditApplication)
    }

}