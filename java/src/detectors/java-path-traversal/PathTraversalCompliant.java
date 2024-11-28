// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-path-traversal@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class PathTraversalCompliant {
    // Compliant: User-supplied relative path is sanitized before use.
    public void createFileCompliant(HttpServletRequest request) {
        String basePath = "/var/data/images/";
        String desiredCategory = request.getParameter("category");

        if (desiredCategory.matches("[a-z]+")) {
            File fileTarget = new File(basePath + desiredCategory);
        } else {
            throw new IllegalArgumentException("Invalid category name");
        }
    }
}
// {/fact}
