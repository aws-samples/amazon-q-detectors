// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-new-string-method-requires-encoding@v1.0 defects=0}
import java.io.UnsupportedEncodingException;

public class StringFromByteArrayRequiresEncodingCompliant {

    // Compliant: String constructor used with byte array and explicit UTF-8 encoding, ensuring consistent behavior across platforms.
    void NewString_ByteArrayVariable_NoEncoding() throws UnsupportedEncodingException {
        byte[] byteArray = "myString".getBytes();
        String myString = new String(byteArray,"UTF-8");
    }
}
// {/fact}
