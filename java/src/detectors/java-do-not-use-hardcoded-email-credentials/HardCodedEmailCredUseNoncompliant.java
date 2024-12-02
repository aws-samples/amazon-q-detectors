// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-do-not-use-hardcoded-email-credentials@v1.0 defects=1}
import javax.mail.PasswordAuthentication;

public class HardCodedEmailCredUseNoncompliant {

    // Noncompliant: Uses hardcoded strings as email credentials.
    public void nonompliant() {
        PasswordAuthentication authentication =
                new PasswordAuthentication("TestUser@xyz.com", "pass123");
    }
}
// {/fact}
