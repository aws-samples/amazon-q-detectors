// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-do-not-use-hardcoded-email-credentials@v1.0 defects=0}
import javax.mail.PasswordAuthentication;
import java.util.Properties;

public class HardCodedEmailCredUseCompliant {

    // Compliant: Uses properties to retrieve email credentials, avoiding hardcoded values and improving security and maintainability.
    public void Compliant() {
        Properties mailProperties = mailProperties = new Properties();
        PasswordAuthentication authentication =
                new PasswordAuthentication(mailProperties.getProperty("mail.user"),
                        mailProperties.getProperty("mail.password"));
    }
}
// {/fact}
