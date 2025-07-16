// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-cryptographic-modes@v1.0 defects=1}
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class EncryptionService {
    
    fun encryptData(data: String, key: ByteArray) {
        val secretKey = SecretKeySpec(key, "AES")
        
        // Noncompliant: Using ECB mode for encryption is insecure
        // as it doesn't provide proper confidentiality
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        
        val encryptedData = cipher.doFinal(data.toByteArray())
    }
}
// {/fact}
