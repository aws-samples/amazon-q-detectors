// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-reflected-open-redirect@v1.0 defects=1}

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.mail.PasswordAuthentication;

public class OpenRedirectNoncompliant {

    // Noncompliant: Vulnerable to open redirect attacks due to unvalidated user input in the redirect URL.
    public void nonompliant(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getParameter("redirectUrl");
        resp.sendRedirect(url);
    }
}
// {/fact}
