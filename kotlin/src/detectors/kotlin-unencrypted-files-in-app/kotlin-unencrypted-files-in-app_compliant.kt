// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-unencrypted-files-in-app@v1.0 defects=0}
import java.io.File
import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import java.util.Base64

class UserDataManager(private val context: Context) {
    
    private fun encrypt(data: String): String {
        // Get or create encryption key from Android KeyStore
        val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
        val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
        val keySpec = KeyGenParameterSpec.Builder(
            "user_data_key",
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .build()
        
        keyGenerator.init(keySpec)
        val secretKey = keyGenerator.generateKey()
        
        // Encrypt the data
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encryptedBytes = cipher.doFinal(data.toByteArray())
        
        return Base64.getEncoder().encodeToString(encryptedBytes)
    }
    
    fun compliant(username: String, password: String) {
        // Compliant: Encrypting sensitive data before storing it
        val encryptedData = encrypt("$username:$password")
        
        // Using a secure storage method
        context.openFileOutput("user_credentials.enc", Context.MODE_PRIVATE).use { output ->
            output.write(encryptedData.toByteArray())
        }
    }
}
// {/fact}
