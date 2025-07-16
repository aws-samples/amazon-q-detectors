// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-improper-instantiation-of-bouncy-castle@v1.0 defects=1}
import org.bouncycastle.jce.provider.BouncyCastleProvider
import javax.crypto.Cipher
import javax.crypto.KeyGenerator

class CryptoService {
    
    fun encrypt(data: String) {
        // Noncompliant: Creating a new BouncyCastleProvider instance for each operation can lead to memory leaks.
        val provider = BouncyCastleProvider()
        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", provider)
        
        val secretKey = KeyGenerator.getInstance("AES").generateKey()
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encrypted = cipher.doFinal(data.toByteArray())
    }
}
// {/fact}
