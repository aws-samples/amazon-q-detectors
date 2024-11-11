// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-smtp@v1.0 defects=1}
import org.apache.commons.mail.SimpleEmail

object InsecureSmtpNoncompliant {

  @throws[Exception]
  def insecureSmtpNoncompliant(): Unit = {
    val email = new SimpleEmail
    email.setHostName("smtp.googlemail.com")
    // Noncompliant: `SSL` is enabled without verifying certificate hostname.
    email.setSSLOnConnect(true)
  }

}
// {/fact}
