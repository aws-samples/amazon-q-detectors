// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-weak-message-digest@v1.0 defects=0}
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.NoSuchProviderException

class WeakMessageDigestCompliant {

  @throws[NoSuchProviderException]
  @throws[NoSuchAlgorithmException]
  def weakMessageDigestCompliant(): Unit = {
    // Compliant: Used secure message digest algorithms.
    MessageDigest.getInstance("SHA-384", "SUN")
  }

}
// {/fact}
