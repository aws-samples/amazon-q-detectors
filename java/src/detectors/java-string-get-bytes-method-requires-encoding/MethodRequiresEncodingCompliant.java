// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-string-get-bytes-method-requires-encoding@v1.0 defects=0}
import java.io.UnsupportedEncodingException;

public class MethodRequiresEncodingCompliant {

    // Compliant: Specifies the character encoding UTF-16 when calling `getBytes()`, ensuring consistent byte representation.
    void compliant() throws UnsupportedEncodingException {
        String myString = "myString";
        myString.getBytes("UTF-16");
    }

}
// {/fact}
