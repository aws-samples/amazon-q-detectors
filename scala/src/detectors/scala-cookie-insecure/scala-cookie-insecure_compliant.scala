// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cookie-insecure@v1.0 defects=0}
import javax.servlet.http.{Cookie, HttpServletResponse}
import play.api.mvc.{ControllerComponents, AbstractController}
import javax.inject.Inject

class CookieInsecureCompliant @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def cookieInsecureCompliant(res: HttpServletResponse, name: String, value: String, secure: Boolean = true, maxAge: Int = 60, httpOnly: Boolean = true): Unit = {
    val cookie = new Cookie(name, value)
    // Compliant: Cookie `setSecure` method is set to `true`.
    cookie.setSecure(true)
    cookie.setMaxAge(maxAge)
    cookie.setHttpOnly(httpOnly)
    res.addCookie(cookie)
  }

}
// {/fact}
