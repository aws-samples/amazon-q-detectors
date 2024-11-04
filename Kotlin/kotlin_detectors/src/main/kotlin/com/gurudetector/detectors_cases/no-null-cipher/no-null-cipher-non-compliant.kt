/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-no-null-cipher@v1.0 defects=1}
import javax.crypto.Cipher
import javax.crypto.NullCipher

// Noncompliant: Used `NullCipher`, which will not use any encryption.
fun no_null_cipher_noncompliant(plainText: ByteArray): ByteArray {
    val doNothingCipher: Cipher = NullCipher()
    val cipherText: ByteArray = doNothingCipher.doFinal(plainText)
    return cipherText
}
// {/fact}
