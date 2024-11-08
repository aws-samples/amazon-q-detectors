// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-deprecatedspringbase64@v1.0 defects=1}
import org.springframework.security.crypto.codec.Base64;

public class DeprecatedMethodNonCompliant {

    // Noncompliant: Deprecated Spring Framework Base64 class used for encoding.
    public String nonCompliant(String password) {
        byte[] encodedId = Base64.encode(password.toLowerCase().getBytes());
        return new String(encodedId);
    }
}
// {/fact}
