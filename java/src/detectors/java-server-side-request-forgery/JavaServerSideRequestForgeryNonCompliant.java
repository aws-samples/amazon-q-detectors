// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-server-side-request-forgery@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerSideRequestForgery {
    public void nonCompliant(HttpServletRequest req, HttpServletResponse resp) {
        URL url = new URL(req.getParameter("url"));
        // Noncompliant: user-supplied URL is not sanitized before creating a connection.
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
    }
}
// {/fact}
