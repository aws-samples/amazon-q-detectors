// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-weak-tls-protocol@v1.0 defects=0}
import java.security.NoSuchAlgorithmException
import javax.net.ssl.SSLContext
import java.lang.reflect.Array

class WeakTlsProtocolCompliant {

  def weakTlsProtocolCompliant(args: Array): Unit = {
    try {
      // Compliant: Using secure `TLS` protocol.
      val context1 = SSLContext.getInstance("TLSv1.3")
    } catch {
      case e: NoSuchAlgorithmException =>
          e.printStackTrace()
    }
  }

}
// {/fact}
