// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-inject-http-parameter-pollution@v1.0 defects=1}
import org.apache.http.client.methods.HttpGet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class HttpParameterPollutionNoncompliant extends HttpServlet {

  def httpParameterPollutionNoncompliant(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    try {
      val item = request.getParameter("item")
      // Noncompliant: Unsanitized input is used in the URL.
      val httpget2 = new HttpGet("http://host.com?param=" + item)
    } catch {
      case e: Exception =>
        e.printStackTrace()
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred")
    }
  }

}
// {/fact}
