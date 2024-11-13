// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-cat-for-reading-files@v1.0 defects=1}
import { execSync } from 'child_process';

function avoidCatNoncompliant(filename: string): void {
    // Noncompliant: `cat` command is used only for reading file.
    const buffer = execSync("cat " + filename).toString();
    console.log(buffer);
}
// {/fact}
