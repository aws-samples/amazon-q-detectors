// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-cookie-httponly@v1.0 defects=0}
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CookieHttpOnlyCompliant {

    // Compliant: `HttpOnly` flag is set to true.
    public void Compliant(HttpServletRequest req, HttpServletResponse res) {
        Cookie c = new Cookie("name", "not-null");
        c.setHttpOnly(true);
        res.addCookie(c);
        res.addHeader("Set-Cookie", "key=value; HttpOnly; Secure; SameSite=Strict");
    }
}
// {/fact}
