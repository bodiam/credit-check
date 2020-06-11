package org.credit.rule

import org.assertj.core.api.Assertions.assertThat
import org.credit.application.CreditApplication
import org.credit.application.Member
import org.credit.application.Product
import org.credit.rule.engine.SequentialEngine
import org.junit.jupiter.api.Test

internal class RuleExecutorTest {

    private val executor = RuleExecutor(SequentialEngine())

    @Test
    fun `successful purchase under limit`() {

        val application = CreditApplication(
            member = Member("Willem", 40, 100000),
            product = Product("Tesla Model 3", 80000)
        )

        val result = executor.process(application)

        assertThat(result.success).isTrue
    }

    @Test
    fun `unsuccessful purchase above limit`() {

        val application = CreditApplication(
            member = Member("Willem", 40, 100000),
            product = Product("Audi R8", 500000)
        )

        val result = executor.process(application)

        assertThat(result.success).isFalse
    }
}