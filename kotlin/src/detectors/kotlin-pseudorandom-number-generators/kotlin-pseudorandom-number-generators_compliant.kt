// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-pseudorandom-number-generators@v1.0 defects=0}
import java.security.SecureRandom

// Compliant: Using `SecureRandom()` to generate random numbers.
fun psrng_compliant() {
    val random = SecureRandom()
    val bytes = ByteArray(20)
    random.nextBytes(bytes)
}
// {/fact}
