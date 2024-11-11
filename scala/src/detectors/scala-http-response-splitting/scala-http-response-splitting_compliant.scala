// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-http-response-splitting@v1.0 defects=0}
import javax.servlet.ServletException
import javax.servlet.http.{Cookie, HttpServlet, HttpServletRequest, HttpServletResponse}
import java.io.IOException
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class HttpResponseSplittingCompliant extends HttpServlet {

  @throws[ServletException]
  @throws[IOException]
  protected def httpResponseSplittingCompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val input = req.getParameter("input")

    // Compliant: The cookie value is sanitized using `URLEncoder` to encode unsafe characters.
    val sanitizedValue = URLEncoder.encode(input, StandardCharsets.UTF_8.toString)
    val c = new Cookie("name", sanitizedValue)
    c.setHttpOnly(true)
    c.setSecure(true)
    resp.addCookie(c)
  }

}
// {/fact}
