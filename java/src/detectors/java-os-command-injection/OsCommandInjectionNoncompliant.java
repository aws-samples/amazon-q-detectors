// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-os-command-injection@v1.0 defects=1}

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class OsCommandInjectionNoncompliant {

    // Noncompliant: User supplied parameter is passed to an OS command and could be malicious.
    public void createProcessNoncompliant(HttpServletRequest request) {
        String favoriteColor = request.getParameter("favoriteColor");
        ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/program", "--color", favoriteColor);
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
// {/fact}
