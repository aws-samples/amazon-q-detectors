// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-inject-file-disclosure@v1.0 defects=1}
import java.io.IOException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class InjectFileDisclosureNoncompliant extends HttpServlet {

  @throws[IOException]
  def injectFileDisclosureNoncompliant(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    try {
        val jspFile = request.getParameter("jspFile")
        var requestDispatcher = request.getRequestDispatcher(jspFile)
        // Noncompliant: Granting access of file to unauthorized users.
        requestDispatcher.include(request, response)
        requestDispatcher = request.getSession.getServletContext.getRequestDispatcher(jspFile)

    } catch {
        case e: Exception =>
            System.out.println(e)
    }
  }

}
// {/fact}
