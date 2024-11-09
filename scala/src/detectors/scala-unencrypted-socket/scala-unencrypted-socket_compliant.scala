// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-unencrypted-socket@v1.0 defects=0}
import java.io.IOException
import javax.net.ssl.SSLSocketFactory

object UnencryptedSocketCompliant {

  @throws[IOException]
  private[this] def unencryptedSocketCompliant(): Unit = {
    // Compliant: Establishing a secure SSL connection on port 443.
    val soc = SSLSocketFactory.getDefault.createSocket("www.google.com", 443)
  }

}
// {/fact}
