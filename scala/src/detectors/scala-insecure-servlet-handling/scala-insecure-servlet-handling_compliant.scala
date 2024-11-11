// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-servlet-handling@v1.0 defects=0}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import javax.servlet.annotation.WebServlet
import org.owasp.encoder.Encode
import org.apache.commons.text.StringEscapeUtils

@WebServlet(Array("/userProfile"))
class InsecureServletHandlingCompliant extends HttpServlet {

  def insecureServletHandlingCompliant(req: HttpServletRequest, res: HttpServletResponse): Unit = {
    res.setContentType("text/html;charset=UTF-8")

    // Compliant: Input sanitization before usage.
    val userName = Encode.forHtml(StringEscapeUtils.escapeHtml4(req.getParameter("name")))
    val userComment = Encode.forHtml(StringEscapeUtils.escapeHtml4(req.getParameter("comment")))

    val writer = res.getWriter
    writer.println("<html><body>")
    writer.println(s"<h1>Welcome, ${userName}!</h1>")
    writer.println(s"<div>Your comment: ${userComment}</div>")
    writer.println("</body></html>")
  }

}
// {/fact}
