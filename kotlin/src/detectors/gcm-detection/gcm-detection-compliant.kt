// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-gcm-detection@v1.0 defects=0}
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.crypto.spec.GCMParameterSpec
import java.util.Base64

class InsecureEncryptorCompliant(private val theKey: SecretKeySpec) {

    companion object {
        private const val BAD_IV = "This is a bad IV"
        private const val GCM_TAG_LENGTH = 16
        private val theIV = ByteArray(12)
        private val base64 = Base64.getEncoder()
    }

    // Compliant: GCM Cipher with new initialization vector is used
    fun gcm_compliant(clearText: String): String {
        val cipher: Cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        val keySpec: SecretKeySpec = SecretKeySpec(theKey.getEncoded(), "AES")
        val theBadIV: ByteArray = BAD_IV.toByteArray()

        val theInnerIV: ByteArray = "Inner IV".toByteArray()
        val gcmParameterSpec: GCMParameterSpec = GCMParameterSpec(GCM_TAG_LENGTH * 8, theInnerIV)
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec)

        val cipherText: ByteArray = cipher.doFinal(clearText.toByteArray())
        val encoded = base64.encodeToString(cipherText)
        return encoded
    }
}
// {/fact}
