// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-server-side-request-forgery@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerSideRequestForgery {
    public void compliant(HttpServletRequest req, HttpServletResponse resp) {
        String urlAllowedPrefix = "https://example.com/";
        String inputUrl = req.getParameter("url");
        if (!inputUrl.startsWith(urlAllowedPrefix))
            throw new IllegalArgumentException();
        URL url = new URL(inputUrl);
        // Compliant: user-supplied URL is sanitized before creating a connection.
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
    }
}
// {/fact}
