// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-unencrypted-socket@v1.0 defects=1}
import java.io.IOException
import java.net.Socket

object UnencryptedSocketNoncompliant {

  @throws[IOException]
  private[this] def nonCompliant(): Unit = {
    // Noncompliant: Establishing an unencrypted connection on port 80.
    val soc = new Socket("www.google.com", 80)
  }

}
// {/fact}
