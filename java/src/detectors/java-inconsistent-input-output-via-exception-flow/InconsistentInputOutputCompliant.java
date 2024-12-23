// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-inconsistent-input-output-via-exception-flow@v1.0 defects=0}
import org.apache.xml.security.utils.JavaUtils;
import java.io.IOException;

public class InconsistentInputOutputCompliant {

    // Compliant: Handles potential IOException and sets 'is' to null if an exception occurs.
    public void compliant(java.io.File file) throws IOException {
        java.io.FileInputStream is = null;
        try {
            is = new java.io.FileInputStream(file);
        } catch (java.io.IOException e) {
            is = null;
        }
        long size = file.length();
        JavaUtils.getBytesFromFile(is.toString());
    }
}
// {/fact}
