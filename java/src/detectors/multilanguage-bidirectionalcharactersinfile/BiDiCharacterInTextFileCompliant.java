// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=multilanguage-bidirectionalcharactersinfile@v1.0 defects=0}
public class BiDiCharacterInTextFileCompliant {

    // Compliant: Does not contain any bidirectional Unicode characters that could potentially obfuscate code.
    public void compliant() {
        boolean root = false;
        System.out.println("You are an admin.");
    }
}
// {/fact}
