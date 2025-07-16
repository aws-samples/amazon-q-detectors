// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-gcm-detection@v1.0 defects=0}
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.crypto.spec.GCMParameterSpec
import java.security.SecureRandom

class GcmEncryptor {
    
    // Compliant: Generating a new random IV for each encryption
    fun encrypt(data: String, key: ByteArray) {
        val random = SecureRandom()
        val iv = ByteArray(12)
        random.nextBytes(iv) // Generate a new random IV
        
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val keySpec = SecretKeySpec(key, "AES")
        val gcmSpec = GCMParameterSpec(128, iv)
        
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmSpec)
        val encrypted = cipher.doFinal(data.toByteArray())
    }
}
// {/fact}
