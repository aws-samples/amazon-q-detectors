// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-inconsistent-input-output-via-exception-flow@v1.0 defects=1}
import org.apache.xml.security.utils.JavaUtils;
import java.io.IOException;

public class InconsistentInputOutputNoncompliant {

    // Noncompliant: Catches IOException but doesn't handle it, potentially leaving 'is' null and causing NullPointerException.
    public void nonCompliant(java.io.File file) throws IOException {
        java.io.FileInputStream is = null;
        try {
            is = new java.io.FileInputStream(file);
        } catch (java.io.IOException e) {
        }
        long size = file.length();
        JavaUtils.getBytesFromFile(is.toString());
    }
}
// {/fact}
