// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-serversiderequestforgery@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerSideRequestForgeryNoncompliant {
    // Noncompliant: Directly uses user-supplied URL without validation, potentially allowing SSRF attacks.
    public void noncompliant(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        URL url = new URL(req.getParameter("url"));
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
    }
}