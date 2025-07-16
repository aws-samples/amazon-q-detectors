// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-crypto-insecure-iv@v1.0 defects=0}
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.security.SecureRandom

fun compliant() {
    // Compliant: Using SecureRandom to generate a cryptographically strong random IV.
    val secureRandom = SecureRandom()
    val iv = ByteArray(16)
    secureRandom.nextBytes(iv)
    val ivSpec = IvParameterSpec(iv)
    
    val key = SecretKeySpec(byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16), "AES")
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec)
}
// {/fact}
