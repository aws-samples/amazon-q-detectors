// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-improper-shutdown-of-executor-service@v1.0 defects=1}
import java.util.concurrent.Executors
import java.util.concurrent.ExecutorService

fun improper_shutdown_of_executor_service_noncompliant() {
    val executorService = Executors.newFixedThreadPool(10)
    
    try {
        executorService.submit { 
            Thread.sleep(1000)
            println("Task completed")
        }
    } catch (e: Exception) {
        println("Error occurred: ${e.message}")
        throw RuntimeException("Task execution failed", e)
    }
    
    // Noncompliant: ExecutorService shutdown is outside try-catch block and may not be reached if an exception occurs.
    executorService.shutdown()
}
// {/fact}
