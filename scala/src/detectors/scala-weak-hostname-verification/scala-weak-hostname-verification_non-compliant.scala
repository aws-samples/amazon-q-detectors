// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-weak-hostname-verification@v1.0 defects=1}
import javax.net.ssl.{HostnameVerifier, SSLSession}

class HostnameVerifierNoncompliant extends HostnameVerifier {

  def verify(hostname: String, session: SSLSession): Boolean = {
    // Noncompliant: Accepts any hostname without verification.
    true
  }

}
// {/fact}
