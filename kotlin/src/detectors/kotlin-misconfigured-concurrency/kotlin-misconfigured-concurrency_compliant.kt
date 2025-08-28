// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-misconfigured-concurrency@v1.0 defects=0}
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

fun misconfigured_concurrency_compliant() {
    val future = CompletableFuture.supplyAsync {
        Thread.sleep(5000)
        "Operation result"
    }
    
    try {
        // Compliant: Using `get()` with a timeout prevents indefinite blocking.
        val result = future.get(10, TimeUnit.SECONDS)
        println("Result: $result")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
// {/fact}
