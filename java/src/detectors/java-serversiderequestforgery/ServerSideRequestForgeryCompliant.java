// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-serversiderequestforgery@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerSideRequestForgeryCompliant {

    // Compliant: Validates user-supplied URL against an allowed prefix before creating a connection, mitigating SSRF risks.
    public void compliant(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String urlAllowedPrefix = "https://example.com/";
        String inputUrl = req.getParameter("url");
        if (!inputUrl.startsWith(urlAllowedPrefix))
            throw new IllegalArgumentException();
        URL url = new URL(inputUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
    }
}
