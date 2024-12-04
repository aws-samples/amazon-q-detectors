// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-files-posix-permissions@v1.0 defects=1}
const fs = require('fs');

function nonCompliant()
{
    // Noncompliant: Excessive permissions have been assigned.
    fs.chmodSync("/tmp/fs", 0o777);
}
// {/fact}
