// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-inject-http-parameter-pollution@v1.0 defects=0}
import org.apache.http.client.methods.HttpGet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.net.URLEncoder

class HttpParameterPollutionCompliant extends HttpServlet {

   def httpParameterPollutionCompliant(request: HttpServletRequest, response: HttpServletResponse): Unit = {
      try {
        val item = request.getParameter("item")
        // Compliant: `URLEncoder.encode` is used to encode the unsanitized input.
        val httpget2 = new HttpGet("http://host.com?param=" + URLEncoder.encode(item, "UTF-8"))
      } catch {
        case e: Exception =>
            e.printStackTrace()
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred")
      }
  }
}
// {/fact}
