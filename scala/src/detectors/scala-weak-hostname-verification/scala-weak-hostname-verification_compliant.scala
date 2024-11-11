// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-weak-hostname-verification@v1.0 defects=0}
import javax.net.ssl.{HostnameVerifier, SSLSession}

class HostnameVerifierCompliant extends HostnameVerifier {

  private val allowedHosts = Set("example.com", "www.example.com")

  def verify(hostname: String, session: SSLSession): Boolean = {
    // Compliant: Validates hostname against an allowed list.
    allowedHosts.contains(hostname)
  }

}
// {/fact}
