/*
* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
* SPDX-License-Identifier: MIT-0
*/

// {fact rule=java-misconfigured-csp-header-comprehensive@v1.0 defects=1}
import javax.servlet.http.HttpServletResponse;

public class MisconfiguredCSPHeaderComprehensiveNonCompliant {
    
    public void nonCompliant(HttpServletResponse response) {
        // Noncompliant: Using `wildcard` in `script-src` directive.
        response.setHeader("Content-Security-Policy", 
	            "default-src 'self'; script-src *; style-src 'self'; frame-ancestors 'none'");
    }
}
// {/fact}
