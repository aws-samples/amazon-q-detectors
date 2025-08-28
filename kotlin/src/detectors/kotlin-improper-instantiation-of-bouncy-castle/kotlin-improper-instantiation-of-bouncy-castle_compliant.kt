// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-improper-instantiation-of-bouncy-castle@v1.0 defects=0}
import org.bouncycastle.jce.provider.BouncyCastleProvider
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import java.security.Security

class CryptoService {
    
    init {
        // Compliant: Adding the BouncyCastleProvider once to the Security providers prevents memory leaks.
        Security.addProvider(BouncyCastleProvider())
    }
    
    fun encrypt(data: String) {
.
        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC")
        
        val secretKey = KeyGenerator.getInstance("AES").generateKey()
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encrypted = cipher.doFinal(data.toByteArray())
    }
}
// {/fact}
