// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insufficient-key-size@v1.0 defects=1}
import java.security._
import java.security.NoSuchAlgorithmException

class InsufficientKeySizeNoncompliant {

  @throws[NoSuchAlgorithmException]
  def insufficientKeySizeNoncompliant(): KeyPair = {
    val keyGen = KeyPairGenerator.getInstance("RSA")
    // Noncompliant: Weak key size of 512 bits.
    keyGen.initialize(512)
    keyGen.generateKeyPair()
  }

}
// {/fact}
