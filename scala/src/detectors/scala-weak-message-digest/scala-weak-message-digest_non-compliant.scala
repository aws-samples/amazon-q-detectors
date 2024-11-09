// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-weak-message-digest@v1.0 defects=1}
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.NoSuchProviderException

class WeakMessageDigestNoncompliant {

  @throws[NoSuchProviderException]
  @throws[NoSuchAlgorithmException]
  def weakMessageDigestNoncompliant(): Unit = {
    // Noncompliant: Used insecure message digest algorithms.
    MessageDigest.getInstance("MD5", "SUN")
  }

}
// {/fact}
