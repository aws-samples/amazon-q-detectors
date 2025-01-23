// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-untrusted-session-data@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UntrustedSessionData {
    public void compliant(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html;charset=UTF-8");

        String param = "noCookieValueSupplied";
        // Compliant: Session attribute name is hardcoded.
        request.getSession().setAttribute(param, "10340");
    }
}
// {/fact}
