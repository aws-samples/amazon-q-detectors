// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cookie-http-only@v1.0 defects=0}
import javax.servlet.http.{Cookie, HttpServletResponse}
import play.api.mvc.{ControllerComponents, AbstractController}
import javax.inject.Inject

class CookieHttpOnlyCompliant @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def cookieHttpOnlyCompliant(res: HttpServletResponse, name: String, value: String, secure: Boolean = true, maxAge: Int = 60): Unit = {
    val cookie = new Cookie(name, value)
    cookie.setSecure(secure)
    cookie.setMaxAge(maxAge)
    // Compliant: Cookie `setHttpOnly` method is set to `true`.
    cookie.setHttpOnly(true)
    res.addCookie(cookie)
  }

}
// {/fact}
