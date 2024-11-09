// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-smtp-injection@v1.0 defects=0}
import javax.mail._
import javax.mail.internet.MimeMessage
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.apache.commons.lang3.StringEscapeUtils

object SmtpInjectionCompliant {

  @throws[Exception]
  def smtpInjectionCompliant(req: HttpServletRequest, resp: HttpServletResponse, session: Session): Unit = {
    val message = new MimeMessage(session)
    // Compliant: Properly sanitizes user input before using it in the subject.
    val sanitizedSubject = StringEscapeUtils.escapeJava(req.getParameter("subject"))
    message.setSubject(sanitizedSubject)
  }

}
// {/fact}
