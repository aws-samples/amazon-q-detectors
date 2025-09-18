// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-cross-site-scripting@v1.0 defects=0}
import java.io.IOException;
import java.io.PrintWriter;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class CrossSiteScriptingJavaRuleCompliant extends HttpServlet {
    // Compliant: Sanitized input is passed to writer.
    protected void compliant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PolicyFactory sanitizer = Sanitizers.FORMATTING.and(Sanitizers.BLOCKS);
        response.setContentType("text/html");
        String name = request.getParameter("yourName");
        PrintWriter writer = response.getWriter();
        String template = sanitizer.sanitize("<p>Hello, " + name + "!</p>");
        writer.write(template);
    }
}
// {/fact}
