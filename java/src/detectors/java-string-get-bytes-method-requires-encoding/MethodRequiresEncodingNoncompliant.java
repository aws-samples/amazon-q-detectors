// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-string-get-bytes-method-requires-encoding@v1.0 defects=1}
import java.io.UnsupportedEncodingException;

public class MethodRequiresEncodingNoncompliant {

    // Noncompliant: Uses `getBytes()` without specifying an encoding, which may lead to platform-dependent results and potential data corruption.
    void nonCompliant() throws UnsupportedEncodingException {
        String myString = "myString";
        myString.getBytes();
    }
}
// {/fact}
