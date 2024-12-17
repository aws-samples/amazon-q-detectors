// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hardcoded-url-and-email-address@v1.0 defects=0}
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HardcodedUrlAndEmailAddressCompliant {
    private static final String support_mail = System.getenv("AMAZON_SUPPORT");

    // Compliant: Uses environment variable for email address, avoiding hardcoding sensitive information.
    public void compliant(){
        String current_mail = support_mail;
    }
}
// {/fact}
