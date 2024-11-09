// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-weak-tls-protocol@v1.0 defects=1}
import java.security.NoSuchAlgorithmException
import javax.net.ssl.SSLContext
import java.lang.reflect.Array

class WeakTlsProtocolNoncompliant {

  def weakTlsProtocolNoncompliant(args: Array): Unit = {
    try {
      // Noncompliant: Using insecure `SSL` protocol.
      val context1 = SSLContext.getInstance("SSL")
    } catch {
      case e: NoSuchAlgorithmException =>
          e.printStackTrace()
    }
  }

}
// {/fact}
