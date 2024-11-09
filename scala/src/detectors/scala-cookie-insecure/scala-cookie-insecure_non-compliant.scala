// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cookie-insecure@v1.0 defects=1}
import javax.servlet.http.{Cookie, HttpServletResponse}
import play.api.mvc.{ControllerComponents, AbstractController}
import javax.inject.Inject

class CookieInsecureNoncompliant @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def cookieInsecureNoncompliant(res: HttpServletResponse, name: String, value: String, secure: Boolean = true, maxAge: Int = 60, httpOnly: Boolean = true): Unit = {
    val cookie = new Cookie(name, value)
    // Noncompliant: Cookie `setSecure` method is set to `false`.
    cookie.setSecure(false)
    cookie.setMaxAge(maxAge)
    cookie.setHttpOnly(httpOnly)
    res.addCookie(cookie)
  }

}
// {/fact}
