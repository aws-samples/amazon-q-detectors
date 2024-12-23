// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-insecure-hashing-of-secret-or-checksum@v1.0 defects=0}

import crypto from 'crypto';
import fs from 'fs';

interface FileContent {
    headers: {
        'Content-Type': string;
        'Content-Length': number;
        ETag: string;
    };
    body: Buffer;
}

function compliant(filePath: string): void {
    fs.readFile(filePath, (err: NodeJS.ErrnoException | null, buf: Buffer) => {
        if (err) {
            console.error('Error reading file:', err);
            throw err;
        }

        const content: FileContent = {
            headers: {
                'Content-Type': type, 
                'Content-Length': buf.length,
                // Compliant: Secure hashing of file checksum.
                ETag: '"' + crypto.createHash('sha256').update(buf).digest('hex') + '"',
            },
            body: buf
        };
    });
}
// {/fact}
