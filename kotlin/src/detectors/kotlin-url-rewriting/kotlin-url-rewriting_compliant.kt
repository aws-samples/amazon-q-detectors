// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-url-rewriting@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun url_rewriting_compliant(request: HttpServletRequest, response: HttpServletResponse): String {
    val session = request.getSession(true)
    session.setAttribute("user", "admin")
    
    // Compliant: Using direct URL without encoding prevents session IDs from appearing in URLs.
    response.setHeader("Set-Cookie", "JSESSIONID=" + session.id + "; HttpOnly; Secure")
    return "redirect:/dashboard"
}
// {/fact}
