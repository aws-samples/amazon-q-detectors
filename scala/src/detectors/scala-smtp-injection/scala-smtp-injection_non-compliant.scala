// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-smtp-injection@v1.0 defects=1}
import javax.mail._
import javax.mail.internet.MimeMessage
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

object SmtpInjectionNoncompliant {

  @throws[Exception]
  def smtpInjectionNoncompliant(req: HttpServletRequest, resp: HttpServletResponse, session: Session): Unit = {
    val message = new MimeMessage(session)
    // Noncompliant: The `subject` is constructed without proper validation or sanitization of input.
    message.setSubject(req.getParameter("subject"))
  }

}
// {/fact}
