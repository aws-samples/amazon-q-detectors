/*
* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
* SPDX-License-Identifier: MIT-0
*/

// {fact rule=java-missing-sri-attribute@v1.0 defects=0}
import javax.servlet.http.HttpServletResponse;

public class MissingSRIAttributeCompliant {
    
    public void compliant(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        // Compliant: `Script` tag with `integrity` attribute.
        out.println("<script src=\"https://cdn.example.com/jquery.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>");
    }
}
// {/fact}
