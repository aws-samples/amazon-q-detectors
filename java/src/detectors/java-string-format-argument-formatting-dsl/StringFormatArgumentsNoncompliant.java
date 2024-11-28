// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-string-format-argument-formatting-dsl@v1.0 defects=1}

import lombok.extern.slf4j.Slf4j;
import java.io.File;

@Slf4j
public class StringFormatArgumentsNoncompliant {

    // Noncompliant: Avoids using the correct format strings for their argument types.
    void formatStringNoncompliant(final File file) {
        final long length = file.length();
        final String s = String.format("File length is %s", length);
        log.info(s);
    }
}
// {/fact}
