package org.credit.rule

import org.assertj.core.api.Assertions.assertThat
import org.credit.application.CreditApplication
import org.credit.application.Member
import org.credit.application.Product
import org.credit.rule.engine.CoroutinesEngine
import org.junit.jupiter.api.Test

internal class CoroutinesRuleExecutorTest {

    private val executor = RuleExecutor(CoroutinesEngine())

    @Test
    fun `successful purchase under limit`() {

        val application = CreditApplication(
            member = Member("Eric", 35, 100000),
            product = Product("Tesla Model S", 150000)
        )

        val result = executor.process(application)

        assertThat(result.success).isTrue
    }

    @Test
    fun `unsuccessful purchase above limit`() {

        val application = CreditApplication(
            member = Member("Eric", 35, 50000),
            product = Product("Maserati GranCabrio", 300000)
        )

        val result = executor.process(application)

        assertThat(result.success).isFalse
    }
}