// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-unvalidated-redirect@v1.0 defects=0}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import java.io.IOException
import java.net.URL

class UnvalidatedRedirectCompliant extends HttpServlet {

  def unvalidatedRedirectCompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    println("Enter the URL for redirection:")
    val urlInput = scala.io.StdIn.readLine()

    val allowedHosts = Set("trusted.com", "example.com")

    try {
      val url = new URL(urlInput)

      if (allowedHosts.contains(url.getHost)) {
        // Compliant: Validate the redirect URL before using it.
        resp.sendRedirect(url.toString)
      } else {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid redirect URL")
      }
    } catch {
      case _: Exception =>
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL format")
    }
  }

}
// {/fact}
