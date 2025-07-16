// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-detect-pbekeyspec-hardcoded-password@v1.0 defects=1}
import java.security.SecureRandom
import java.security.spec.KeySpec
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

fun noncompliant() {
    val random = SecureRandom()
    val salt = ByteArray(16)
    random.nextBytes(salt)
    
    // Noncompliant: Using a hardcoded password in PBEKeySpec exposes sensitive credentials.
    val spec: KeySpec = PBEKeySpec(charArrayOf('P', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3'), salt, 65536, 128)
    
    val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
    val hash = factory.generateSecret(spec).encoded
    (spec as PBEKeySpec).clearPassword()
}
// {/fact}
