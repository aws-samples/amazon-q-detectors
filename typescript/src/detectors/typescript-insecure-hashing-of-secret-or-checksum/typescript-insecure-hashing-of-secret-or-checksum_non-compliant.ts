// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-insecure-hashing-of-secret-or-checksum@v1.0 defects=1}
import fs from 'fs';
import crypto from 'crypto';

interface FileContent {
    headers: {
        'Content-Type': string;
        'Content-Length': number;
        ETag: string;
    };
    body: Buffer;
}

function nonCompliant(filePath: string): void {
    fs.readFile(filePath, (err: NodeJS.ErrnoException | null, buf: Buffer) => {
        if (err) {
            console.error('Error reading file:', err);
            throw err;
        }

        const content: FileContent = {
            headers: {
                'Content-Type': type, 
                'Content-Length': buf.length,
                // Noncompliant: Insecure hashing of file checksum.
                ETag: '"' + crypto.createHash('md5').update(buf).digest('hex') + '"', 
            },
            body: buf
        };
    });
}
// {/fact}
