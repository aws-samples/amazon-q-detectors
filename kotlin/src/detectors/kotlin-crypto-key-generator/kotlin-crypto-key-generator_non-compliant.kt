// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-crypto-key-generator@v1.0 defects=1}
import java.security.NoSuchAlgorithmException
import javax.crypto.KeyGenerator

@Throws(NoSuchAlgorithmException::class)
fun cryptoKeyGeneratorNonCompliant() {
    // Noncompliant: Key generator is initialized after key generation, which is unnecessary and insecure.
    val generator = KeyGenerator.getInstance("AES")
    generator.generateKey()
    generator.init(128)
}
// {/fact}
