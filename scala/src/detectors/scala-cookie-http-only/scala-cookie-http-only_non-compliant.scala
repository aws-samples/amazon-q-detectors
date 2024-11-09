// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cookie-http-only@v1.0 defects=1}
import javax.servlet.http.{Cookie, HttpServletResponse}
import play.api.mvc.{ControllerComponents, AbstractController}
import javax.inject.Inject

class CookieHttpOnlyNoncompliant @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def cookieHttpOnlyNoncompliant(res: HttpServletResponse, name: String, value: String, secure: Boolean = true, maxAge: Int = 60): Unit = {
    val cookie = new Cookie(name, value)
    cookie.setSecure(secure)
    cookie.setMaxAge(maxAge)
    // Noncompliant: Cookie `setHttpOnly` method is set to `false`.
    cookie.setHttpOnly(false)
    res.addCookie(cookie)
  }

}
// {/fact}
