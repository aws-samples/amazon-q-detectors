// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-os-command-injection@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class OsCommandInjectionCompliant {

    // Compliant: User-supplied parameter is sanitized before passing it to an OS command.
    public void createProcessCompliant(HttpServletRequest request) {
        String favoriteColor = request.getParameter("favoriteColor");
        if (!favoriteColor.matches("[a-z]+")) {
            throw new IllegalArgumentException();
        }
        ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/program", "--color", favoriteColor);
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
// {/fact}
