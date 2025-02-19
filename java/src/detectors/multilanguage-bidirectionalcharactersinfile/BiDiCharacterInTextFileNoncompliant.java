// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=multilanguage-bidirectionalcharactersinfile@v1.0 defects=1}
public class BiDiCharacterInTextFileNoncompliant {

    // Noncompliant: Contains bidirectional Unicode characters that could potentially obfuscate code and alter its logical flow.
    public void nonCompliant() {
        boolean root = false;
        /*‮ } ⁦if (root)⁩ ⁦ There is a naughty character */
        System.out.println("You are an admin.");
        /* in intellij you can actually see it on the cursor ‮ { ⁦*/
    }
}
// {/fact}
