// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-cipher-block-chaining@v1.0 defects=0}
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import java.security.InvalidKeyException
import java.security.Key
import java.security.NoSuchAlgorithmException

class InsecureCipherBlockChainingCompliant {

  @throws[NoSuchPaddingException]
  @throws[NoSuchAlgorithmException]
  @throws[IllegalBlockSizeException]
  @throws[BadPaddingException]
  @throws[InvalidKeyException]
  def insecureCipherBlockChainingCompliant(key: Key, plainText: Array[Byte]): Unit = {
    // Compliant: Uses `GCM` mode with integrity checks.
    val c = Cipher.getInstance("DES/GCM/PKCS5Padding")
    c.init(Cipher.ENCRYPT_MODE, key)
    val cipherText = c.doFinal(plainText)
  }

}
// {/fact}
