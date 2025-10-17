/*
* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
* SPDX-License-Identifier: MIT-0
*/

// {fact rule=java-unsafe-CSP-frame-ancestors@v1.0 defects=0}
import javax.servlet.http.HttpServletResponse;

public class UnsafeCSPFrameAncestorsCompliant {

    public void compliant(HttpServletResponse response) {
        // Compliant: Properly restricting `frame-ancestors` to `none`.
        response.setHeader("Content-Security-Policy", 
	            "default-src 'self'; script-src 'self'; frame-ancestors 'none'");
    }
}
// {/fact}
