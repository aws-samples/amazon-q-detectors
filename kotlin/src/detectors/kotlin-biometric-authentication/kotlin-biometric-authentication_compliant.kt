// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-biometric-authentication@v1.0 defects=0}
import android.content.Context
import android.hardware.biometrics.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.SecretKey
import android.security.keystore.KeyProperties

fun biometricAuthenticationCompliant(activity: FragmentActivity) {
    val executor = ContextCompat.getMainExecutor(activity)
    val callback = object : BiometricPrompt.AuthenticationCallback() {
        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
            val cryptoObject = result.cryptoObject
            if (cryptoObject?.cipher != null) {
                // Compliant: Using the authenticated cipher to decrypt sensitive data.
                val decryptedData = decryptData(cryptoObject.cipher)
                displayData(decryptedData)
            }
        }
    }
    
    val cipher = getCipher()
    initCipher(cipher)
    val cryptoObject = BiometricPrompt.CryptoObject(cipher)
    
    val biometricPrompt = BiometricPrompt(activity, executor, callback)
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Authentication Required")
        .setSubtitle("Please authenticate to continue")
        .setNegativeButtonText("Cancel")
        .build()
    
    // Compliant: Using BiometricPrompt.authenticate() with a CryptoObject for secure authentication.
    biometricPrompt.authenticate(promptInfo, cryptoObject)
}

private fun getCipher(): Cipher = Cipher.getInstance(
    KeyProperties.KEY_ALGORITHM_AES + "/" +
    KeyProperties.BLOCK_MODE_CBC + "/" +
    KeyProperties.ENCRYPTION_PADDING_PKCS7
)

private fun initCipher(cipher: Cipher) {
    val keyStore = KeyStore.getInstance("AndroidKeyStore")
    keyStore.load(null)
    val key = keyStore.getKey("biometric_key", null) as SecretKey
    cipher.init(Cipher.ENCRYPT_MODE, key)
}

private fun decryptData(cipher: Cipher): String = "Decrypted data"
private fun displayData(data: String) {}
// {/fact}
