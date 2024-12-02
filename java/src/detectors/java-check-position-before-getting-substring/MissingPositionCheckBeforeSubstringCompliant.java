// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-check-position-before-getting-substring@v1.0 defects=0}

public class MissingPositionCheckBeforeSubstringCompliant {

    // Compliant: Checked if substring is part of the string.
    public void checkSubStringCompliant(String sampleString) {
        final String sampleSubstring = "sample";
        final int index = sampleString.lastIndexOf(sampleSubstring);
        final String subString = index > 0 ? sampleString.substring(0, index) : sampleString;
    }
}
// {/fact}
