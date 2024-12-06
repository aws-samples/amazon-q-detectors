// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-string-format-argument-formatting-dsl@v1.0 defects=1}
import java.io.File;

class StringFormatNoncompliant {

    void nonCompliant(final File file) {
        final long length = file.length();
        // Noncompliant: Avoids using the correct format strings for their argument types.
        final String s = String.format("File length is %s", length);
    }
}
// {/fact}
