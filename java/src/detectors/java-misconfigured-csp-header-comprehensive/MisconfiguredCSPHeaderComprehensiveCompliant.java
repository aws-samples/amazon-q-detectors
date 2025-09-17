/*
* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
* SPDX-License-Identifier: MIT-0
*/

// {fact rule=java-misconfigured-csp-header-comprehensive@v1.0 defects=0}
import javax.servlet.http.HttpServletResponse;

public class MisconfiguredCSPHeaderComprehensiveCompliant {
    
    public void compliant(HttpServletResponse response) {
        // Compliant: Properly configured `CSP` with `no wildcards`.
        response.setHeader("Content-Security-Policy", 
	             "default-src 'self'; script-src 'self' https://trusted-cdn.com; frame-ancestors 'none'");
    }
}
// {/fact}
