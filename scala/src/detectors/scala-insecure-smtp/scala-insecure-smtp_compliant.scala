// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-smtp@v1.0 defects=0}
import org.apache.commons.mail.SimpleEmail

object InsecureSmtpCompliant {

  @throws[Exception]
  def insecureSmtpCompliant(): Unit = {
    val email = new SimpleEmail
    email.setHostName("smtp.googlemail.com")
    // Compliant: `SSL` is not enabled, avoiding unverified certificate hostname usage.
    email.setSSLOnConnect(false)
  }

}
// {/fact}
