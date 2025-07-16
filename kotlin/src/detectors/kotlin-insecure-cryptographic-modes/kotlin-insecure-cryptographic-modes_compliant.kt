// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-cryptographic-modes@v1.0 defects=0}
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.crypto.spec.GCMParameterSpec
import java.security.SecureRandom

fun compliant() {
    val key = SecretKeySpec(ByteArray(16), "AES")
    
    // Compliant: Using GCM mode provides both confidentiality and integrity protection.
    val cipher = Cipher.getInstance("AES/GCM/NoPadding")
    
    val random = SecureRandom()
    val iv = ByteArray(12)
    random.nextBytes(iv)
    
    val gcmSpec = GCMParameterSpec(128, iv)
    cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec)
    
    val data = "Sensitive information".toByteArray()
    val encryptedData = cipher.doFinal(data)
}
// {/fact}
