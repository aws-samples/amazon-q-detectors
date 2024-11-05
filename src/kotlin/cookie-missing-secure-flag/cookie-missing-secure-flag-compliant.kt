// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-cookie-missing-secure-flag@v1.0 defects=0}
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.RequestParam

// Compliant: The `Secure` attribute of cookies is set to `true`.
fun cookie_missing_secure_flag_compliant(@RequestParam value: String, response: HttpServletResponse) {
    var cookie: Cookie = Cookie("cookie", value)
    cookie.setSecure(true)
    response.addCookie(cookie)
}
// {/fact}
