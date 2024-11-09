// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-http-response-splitting@v1.0 defects=1}
import javax.servlet.ServletException
import javax.servlet.http.{Cookie, HttpServlet, HttpServletRequest, HttpServletResponse}
import java.io.IOException

class HttpResponseSplittingNoncompliant extends HttpServlet {

  @throws[ServletException]
  @throws[IOException]
  protected def httpResponseSplittingNoncompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val input = req.getParameter("input")
    val c = new Cookie("name", null)

    // Noncompliant: The cookie value is set to the unsanitized input parameter.
    c.setValue(input)
    c.setHttpOnly(true)
    c.setSecure(true)
    resp.addCookie(c)
  }
}

// {/fact}
