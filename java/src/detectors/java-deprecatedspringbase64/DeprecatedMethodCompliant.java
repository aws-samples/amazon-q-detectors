// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-deprecatedspringbase64@v1.0 defects=0}

public class DeprecatedMethodCompliant {

    // Compliant: Standard Java SDK Base64 class used for encoding.
    public String compliant(String password) {
        byte[] encodedId = java.util.Base64.getEncoder().encode(password.toLowerCase().getBytes());
        return new String(encodedId);
    }
}
// {/fact}
