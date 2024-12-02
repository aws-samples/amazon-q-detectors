// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-path-traversal@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class PathTraversalNoncompliant {
    // Noncompliant: User-supplied relative path is not sanitized and could contain malicious characters.
    public void createFileNoncompliant(HttpServletRequest request, HttpServletResponse response) {
        String basePath = "/var/data/images/";
        String desiredCategory = request.getParameter("category");

        File fileTarget = new File(basePath + desiredCategory);
    }
}
// {/fact}
