// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-crypto-key-generator@v1.0 defects=0}
import java.security.NoSuchAlgorithmException
import javax.crypto.KeyGenerator
import java.security.SecureRandom

@Throws(NoSuchAlgorithmException::class)
fun cryptoKeyGeneratorCompliant() {
    // Compliant: Key generator is properly initialized before key generation.
    val generator = KeyGenerator.getInstance("AES")
    generator.init(256, SecureRandom())
    val secretKey = generator.generateKey()
}
// {/fact}
