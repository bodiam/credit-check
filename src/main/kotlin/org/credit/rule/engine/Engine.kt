package org.credit.rule.engine

import org.credit.application.CreditApplication
import org.credit.application.CreditResult

interface Engine {

    fun execute(creditApplication: CreditApplication): CreditResult
}