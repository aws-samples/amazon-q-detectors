// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-improper-shutdown-of-executor-service@v1.0 defects=0}
import java.util.concurrent.Executors
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit

fun improper_shutdown_of_executor_service_compliant() {
    val executorService = Executors.newFixedThreadPool(10)
    
    try {
        executorService.submit { 
            Thread.sleep(1000)
            println("Task completed")
        }
    } catch (e: Exception) {
        println("Error occurred: ${e.message}")
        throw RuntimeException("Task execution failed", e)
    } finally {
        // Compliant: ExecutorService is properly shut down in a finally block to ensure it happens even if exceptions occur.
        executorService.shutdown()
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow()
            }
        } catch (e: InterruptedException) {
            executorService.shutdownNow()
            Thread.currentThread().interrupt()
        }
    }
}
// {/fact}
