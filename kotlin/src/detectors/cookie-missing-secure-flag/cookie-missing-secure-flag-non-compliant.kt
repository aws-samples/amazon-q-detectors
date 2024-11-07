// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-cookie-missing-secure-flag@v1.0 defects=1}
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.RequestParam

// Noncompliant:  The `Secure` flag of cookies is set to `false`.
fun cookie_missing_secure_flag_noncompliant(@RequestParam value: String, response: HttpServletResponse) {
    var cookie: Cookie = Cookie("cookie", value)
    cookie.setSecure(false)
    cookie.setHttpOnly(false)
    response.addCookie(cookie)
}
// {/fact}
