/*
* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
* SPDX-License-Identifier: MIT-0
*/

// {fact rule=java-unsafe-CSP-frame-ancestors@v1.0 defects=1}
import javax.servlet.http.HttpServletResponse;

public class UnsafeCSPFrameAncestorsNonCompliant {

    public void nonCompliant(HttpServletResponse response) {
        // Noncompliant: Completely missing `Content-Security-Policy` header.
        response.setHeader("X-Frame-Options", "DENY");
        response.setHeader("X-XSS-Protection", "1; mode=block");
    }
}
// {/fact}
