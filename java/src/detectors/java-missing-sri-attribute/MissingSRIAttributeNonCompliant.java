/*
* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
* SPDX-License-Identifier: MIT-0
*/

// {fact rule=java-missing-sri-attribute@v1.0 defects=1}
import javax.servlet.http.HttpServletResponse;

public class MissingSRIAttributeNonCompliant {
    
    public void nonCompliant(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        // Noncompliant: `Script` tag without `integrity` attribute.
        out.println("<script src=\"https://cdn.example.com/script.js\"></script>");
    }
}
// {/fact}
