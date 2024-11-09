// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-servlet-handling@v1.0 defects=1}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import javax.servlet.annotation.WebServlet

@WebServlet(Array("/userProfile"))
class InsecureServletHandlingNoncompliant extends HttpServlet {

  def insecureServletHandlingNoncompliant(req: HttpServletRequest, res: HttpServletResponse): Unit = {
    res.setContentType("text/html;charset=UTF-8")

    val userName = req.getParameter("name")
    val userComment = req.getParameter("comment")

    // Noncompliant: Directly using user input without sanitization.
    res.getWriter.println("<html><body>")
    res.getWriter.println(s"<h1>Welcome, ${userName}!</h1>")
    res.getWriter.println(s"<div>Your comment: ${userComment}</div>")
    res.getWriter.println("</body></html>")
  }

}
// {/fact}
