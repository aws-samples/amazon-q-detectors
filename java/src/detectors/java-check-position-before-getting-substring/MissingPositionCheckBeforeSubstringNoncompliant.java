// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-check-position-before-getting-substring@v1.0 defects=1}

public class MissingPositionCheckBeforeSubstringNoncompliant {

    // Noncompliant: Lack of substring validation.
    public void checkSubStringNoncompliant(String sampleString) {
        final String sampleSubstring = "sample";
        final int index = sampleString.lastIndexOf(sampleSubstring);
        final String subString = sampleString.substring(0, index);
    }
}
// {/fact}
