// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-cookie-missing-httponly@v1.0 defects=0}
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

// Compliant: The `HttpOnly` flag of cookies is set to `true`.
fun cookie_missing_httponly_compliant(value: String, response: HttpServletResponse) {
    val cookie: Cookie = Cookie("cookie", value)
    cookie.setHttpOnly(true)
    response.addCookie(cookie)
}
// {/fact}
