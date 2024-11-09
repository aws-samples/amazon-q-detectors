// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-unvalidated-redirect@v1.0 defects=1}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import java.io.IOException

class UnvalidatedRedirectNoncompliant extends HttpServlet {

  def unvalidatedRedirectNoncompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    println("Enter the URL for redirection:")
    val url = scala.io.StdIn.readLine()
    // Noncompliant: User input is directly used for redirection without validation.
    resp.sendRedirect(url)
  }

}
// {/fact}
