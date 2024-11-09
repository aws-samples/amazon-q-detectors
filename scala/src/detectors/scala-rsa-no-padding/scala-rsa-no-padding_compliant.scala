// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-rsa-no-padding@v1.0 defects=0}
import java.security.{KeyPairGenerator, PublicKey}
import javax.crypto.Cipher

class RsaNoPaddingCompliant {

  def rsaNoPaddingCompliant(args: Array[String]): Unit = {
    val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
    keyPairGenerator.initialize(2048)
    val keyPair = keyPairGenerator.generateKeyPair()
    val publicKey: PublicKey = keyPair.getPublic

    val plaintext = "Sensitive data"

    // Compliant: Encrypted with `RSA` using `OAEP` padding.
    val cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding")
    cipher.init(Cipher.ENCRYPT_MODE, publicKey)
    val ciphertext = cipher.doFinal(plaintext.getBytes("UTF-8"))
    println("Encrypted: " + javax.xml.bind.DatatypeConverter.printHexBinary(ciphertext))
  }

}
// {/fact}
