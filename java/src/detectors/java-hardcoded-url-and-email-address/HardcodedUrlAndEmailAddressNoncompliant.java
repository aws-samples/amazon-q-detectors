// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hardcoded-url-and-email-address@v1.0 defects=1}
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HardcodedUrlAndEmailAddressNoncompliant {

    // Noncompliant: Contains a hardcoded email address, which should be avoided for security and maintainability.
    public void nonCompliant(){
        String support_mail = "abc@amazon.com";
    }
}
// {/fact}
