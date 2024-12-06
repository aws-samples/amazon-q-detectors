// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-string-format-argument-formatting-dsl@v1.0 defects=0}
import java.io.File;

class StringFormatCompliant {

    void compliant(final File file) {
        final long length = file.length();
        // Compliant: Uses the correct format strings for their argument types.
        final String s = String.format("File length is %d", length);
    }
}
// {/fact}
