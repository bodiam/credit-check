package org.credit.rule.coroutines

import kotlinx.coroutines.*
import kotlin.system.*

fun main() = runBlocking<Unit> {
//    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne2() }
        val two = async { doSomethingUsefulTwo2() }
        println("The answer is ${one.await() + two.await()}")
//    }
//    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne2(): Int {
    delay(10000L) // pretend we are doing something useful here
    println("x")
    return 13
}

suspend fun doSomethingUsefulTwo2(): Int {
    delay(5000L) // pretend we are doing something useful here, too
    println("y")
    return 29
}