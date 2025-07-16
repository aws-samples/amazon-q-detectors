// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-cookie-missing-httponly@v1.0 defects=1}
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

// Noncompliant: The `HttpOnly` flag of cookies is set to `false`.
fun cookie_missing_httponly_noncompliant(value: String, response: HttpServletResponse) {
    val cookie: Cookie = Cookie("cookie", value)
    cookie.setHttpOnly(false)
    response.addCookie(cookie)
}
// {/fact}
