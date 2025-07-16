// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-misconfigured-concurrency@v1.0 defects=1}
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future

fun misconfigured_concurrency_noncompliant() {
    val future = CompletableFuture.supplyAsync {
        Thread.sleep(5000)
        "Operation result"
    }
    
    try {
        // Noncompliant: Using `get()` without a timeout can lead to indefinite blocking.
        val result = future.get()
        println("Result: $result")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
// {/fact}
