// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-random@v1.0 defects=0}
import java.security.SecureRandom

class InsecureRandomCompliant {

  def insecureRandomCompliant(): String = {
    // Compliant: `SecureRandom` provides cryptographically secure random values.
    val secureRandomInstance = new SecureRandom()
    val secureBytes = new Array[Byte](32)
    secureRandomInstance.nextBytes(secureBytes)
    secureBytes.map("%02x".format(_)).mkString
  }

}
// {/fact}
