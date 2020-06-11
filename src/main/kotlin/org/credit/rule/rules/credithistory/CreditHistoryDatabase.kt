package org.credit.rule.rules.credithistory

class CreditHistoryDatabase {
    fun findAll(name: String): List<CreditHistory> {

        return listOf(
            CreditHistory("bought car", 250),
            CreditHistory("bought house", 400),
            CreditHistory("late payment", -50),
            CreditHistory("electricity payment", 100)
        )
    }
}

class  CreditHistory(
    val description: String,
    val score: Int
)