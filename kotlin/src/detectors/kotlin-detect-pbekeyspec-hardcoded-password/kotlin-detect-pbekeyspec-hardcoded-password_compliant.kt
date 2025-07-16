// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-detect-pbekeyspec-hardcoded-password@v1.0 defects=0}
import java.security.SecureRandom
import java.security.spec.KeySpec
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

fun compliant(userPassword: String) {
    val random = SecureRandom()
    val salt = ByteArray(16)
    random.nextBytes(salt)
    
    // Compliant: Using a user-provided password instead of hardcoding credentials.
    val spec: KeySpec = PBEKeySpec(userPassword.toCharArray(), salt, 65536, 128)
    
    val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
    val hash = factory.generateSecret(spec).encoded
    (spec as PBEKeySpec).clearPassword()
}
// {/fact}
