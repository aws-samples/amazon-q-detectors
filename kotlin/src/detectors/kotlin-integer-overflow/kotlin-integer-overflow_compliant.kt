// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-integer-overflow@v1.0 defects=0}
fun compliant() {
    val a: Int = Int.MAX_VALUE
    val b: Int = 1
    
    // Compliant: Converting to Long before addition prevents integer overflow.
    val result: Long = a.toLong() + b
    
    println("Result of addition: $result")
}
// {/fact}
