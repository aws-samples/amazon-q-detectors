// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-files-posix-permissions@v1.0 defects=0}
const fs = require('fs');

function compliant()
{
    // Compliant: Permissions assigned to owner and owner group.
    fs.chmod("sample.txt", fs.constants.S_IRWXU,(err => {}));
}
// {/fact}
