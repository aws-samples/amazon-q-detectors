// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-crypto-insecure-iv@v1.0 defects=1}
import { createReadStream, createWriteStream } from 'fs';
import { scryptSync, createCipheriv } from 'crypto';

function nonCompliant(): void {
    const algorithm: string = 'aes-256-cbc';
    const password: string = process.env.SECRET_PASSWORD;
    const key: Buffer = scryptSync(password, 'salt', 24);
    // Noncompliant: Using a duplicate or predictable Initialization Vector (IV) for a cryptographic cipher makes the resulting ciphertext to a dictionary attack.
    const iv: Buffer = Buffer.alloc(16, 0);

    const decipher = createCipheriv(algorithm, key, iv);

    const input = createReadStream('test.enc');
    const output = createWriteStream('test.js');
    input.pipe(decipher).pipe(output);
}
// {/fact}
