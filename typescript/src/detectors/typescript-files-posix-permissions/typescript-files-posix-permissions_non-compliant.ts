// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-files-posix-permissions@v1.0 defects=1}
import fs from 'fs';

function nonCompliant(): void {
    // Noncompliant: Excessive permissions have been assigned.
    fs.chmodSync("/tmp/fs", 0o777);
}

// {/fact}
