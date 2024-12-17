// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-new-string-method-requires-encoding@v1.0 defects=1}
public class StringFromByteArrayRequiresEncodingNoncompliant {

    // Noncompliant: String constructor used with byte array without specifying character encoding, risking platform-dependent behavior.
    void NewString_ByteArrayVariable_NoEncoding() {
        byte[] byteArray = "myString".getBytes();
        String myString = new String(byteArray);
    }
}
// {/fact}
