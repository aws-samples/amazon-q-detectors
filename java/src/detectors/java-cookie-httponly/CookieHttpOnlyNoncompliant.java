// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-cookie-httponly@v1.0 defects=1}
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CookieHttpOnlyNoncompliant {

    // Noncompliant: By default, the `HttpOnly` flag is not set to true.
    public void Noncompliant(HttpServletRequest req, HttpServletResponse resp) {
        Cookie c = new Cookie("name", "not-null");
        resp.addCookie(c);
    }
}
// {/fact}
