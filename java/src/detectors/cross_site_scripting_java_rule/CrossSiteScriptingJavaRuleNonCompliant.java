// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-cross-site-scripting@v1.0 defects=1}
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class CrossSiteScriptingJavaRuleNonCompliant extends HttpServlet{

    // Noncompliant: Unsanitized input is passed to writer.
    public void nonCompliant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");
        String name = request.getParameter("yourName");
        PrintWriter writer = response.getWriter();
        writer.write("<p>Hello, " + name + "!</p>");
    }
}
// {/fact}
