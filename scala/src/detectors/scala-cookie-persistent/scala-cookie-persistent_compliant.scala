// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cookie-persistent@v1.0 defects=0}
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

class CookiePersistentCompliant {

  def cookiePersistentCompliant(res: HttpServletResponse): Unit = {
    val cookie = new Cookie("key", "value")
    cookie.setSecure(true)
    cookie.setHttpOnly(true)
    // Compliant: `MaxAge` set to one week.
    cookie.setMaxAge(604800)
    res.addCookie(cookie)
  }

}
// {/fact}
