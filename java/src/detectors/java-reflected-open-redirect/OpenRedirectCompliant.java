// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-reflected-open-redirect@v1.0 defects=0}
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
public class OpenRedirectCompliant {

    // Compliant: Attempts to mitigate open redirect by using a fixed base URL
    public void Compliant(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String urlParameters = req.getParameter("urlParameters");
        String url = "https://abc.com/" + urlParameters;
        resp.sendRedirect(url);
    }
}
// {/fact}
