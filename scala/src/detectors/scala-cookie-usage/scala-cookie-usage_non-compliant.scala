// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cookie-usage@v1.0 defects=1}
import javax.servlet.http.{Cookie, HttpServletRequest}
import org.slf4j.LoggerFactory

class CookieUsageNoncompliant {

  def cookieUsageNoncompliant(req: HttpServletRequest): Option[String] = {
    val logger = LoggerFactory.getLogger(getClass)
    val c: Cookie = req.getCookies.head
    // Noncompliant: Retrieved and used cookies without checking for secure attributes.
    val cookieName = c.getName
    logger.info(s"Cookie Name: $cookieName")
    Some(cookieName)
  }

}
// {/fact}
