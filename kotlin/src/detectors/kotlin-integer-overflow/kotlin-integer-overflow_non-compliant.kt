// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-integer-overflow@v1.0 defects=1}
fun noncompliant() {
    val a: Int = Int.MAX_VALUE
    val b: Int = 1
    
    // Noncompliant: Adding values without checking for potential overflow.
    val result: Int = a + b
    
    println("Result of addition: $result")
}
// {/fact}
