// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-url-rewriting@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun url_rewriting_noncompliant(request: HttpServletRequest, response: HttpServletResponse): String {
    val session = request.getSession(true)
    session.setAttribute("user", "admin")
    
    // Noncompliant: Using encodeURL exposes session IDs in URLs, making them vulnerable to theft.
    val encodedURL = response.encodeURL("/dashboard")
    return "redirect:$encodedURL"
}
// {/fact}
