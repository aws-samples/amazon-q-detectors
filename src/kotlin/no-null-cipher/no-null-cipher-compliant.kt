// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-no-null-cipher@v1.0 defects=0}
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.crypto.spec.IvParameterSpec

// Compliant: Avoided use of `NullCipher` while encrypting value.
fun no_null_cipher_compliant(plainText: ByteArray): ByteArray {
    val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    val cipherText: ByteArray = cipher.doFinal(plainText)
    return cipherText
}
// {/fact}
