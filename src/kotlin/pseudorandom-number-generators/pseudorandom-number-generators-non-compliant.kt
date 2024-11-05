// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-pseudorandom-number-generators@v1.0 defects=1}
import java.util.Random

// Noncompliant: `Random()` is not a secure random number generator.
fun psrng_noncompliant() {
    val random = Random() 
    val bytes = ByteArray(20)
    random.nextBytes(bytes)
}
// {/fact}
