// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cookie-usage@v1.0 defects=0}
import javax.servlet.http.{HttpServletRequest, Cookie}

class CookieUsageCompliant {

  def cookieUsageCompliant(req: HttpServletRequest): Option[String] = {
    val cookies = Option(req.getCookies)
    if (req.isSecure && cookies.exists(_.nonEmpty)) {
      val c = cookies.get.head
      // Compliant: Retrieved and used cookies after checking for secure attributes.
      if (c.getSecure && c.isHttpOnly) {
          Some(c.getName)
      } else {
          None
      }
    } else {
      None
    }
  }

}
// {/fact}
