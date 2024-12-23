// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-files-posix-permissions@v1.0 defects=0}
import fs from 'fs';

function compliant(): void {
    // Compliant: Permissions assigned to owner and owner group.
    fs.chmod("sample.txt", fs.constants.S_IRWXU, (err: NodeJS.ErrnoException | null): void => {
        if (err) {
            console.error('Error changing file permissions:', err);
        }
    });
}

// {/fact}
