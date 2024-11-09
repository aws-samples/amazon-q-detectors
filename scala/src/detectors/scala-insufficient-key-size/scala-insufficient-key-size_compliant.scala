// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insufficient-key-size@v1.0 defects=0}
import java.security._
import java.security.spec.RSAKeyGenParameterSpec
import java.security.NoSuchAlgorithmException
import java.security.InvalidAlgorithmParameterException

class InsufficientKeySizeCompliant {

  @throws[NoSuchAlgorithmException]
  @throws[InvalidAlgorithmParameterException]
  def insufficientKeySizeCompliant(): KeyPair = {
    val keyGen = KeyPairGenerator.getInstance("RSA")
    keyGen.initialize(new RSAKeyGenParameterSpec(2048, RSAKeyGenParameterSpec.F4))
    // Compliant: Strong key size of 2048 bits.
    keyGen.generateKeyPair()
  }

}
// {/fact}
