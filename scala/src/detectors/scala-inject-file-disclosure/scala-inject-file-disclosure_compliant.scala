// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-inject-file-disclosure@v1.0 defects=0}
import java.io.IOException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.apache.commons.io.FilenameUtils

class InjectFileDisclosureCompliant extends HttpServlet {

  @throws[IOException]
  def injectFileDisclosureCompliant(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    try {
      val jspFile = request.getParameter("jspFile")
      val normalizedPath = FilenameUtils.normalize(jspFile)
      var requestDispatcher = request.getRequestDispatcher(normalizedPath)
      // Compliant: Sanitizing the file path before using it with the `RequestDispatcher`.
      requestDispatcher.include(request, response)
      requestDispatcher = request.getSession.getServletContext.getRequestDispatcher(normalizedPath)

    } catch {
      case e: Exception =>
          System.out.println(e)
    }
  }

}
// {/fact}
