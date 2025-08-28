// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-gcm-detection@v1.0 defects=1}
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.crypto.spec.GCMParameterSpec

class GcmEncryptor {
    
    // Noncompliant: Using a static IV for GCM encryption
    fun encrypt(data: String, key: ByteArray) {
        val staticIV = ByteArray(12) // Static IV that will be reused
        
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val keySpec = SecretKeySpec(key, "AES")
        val gcmSpec = GCMParameterSpec(128, staticIV)
        
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmSpec)
        val encrypted = cipher.doFinal(data.toByteArray())
    }
}
// {/fact}
