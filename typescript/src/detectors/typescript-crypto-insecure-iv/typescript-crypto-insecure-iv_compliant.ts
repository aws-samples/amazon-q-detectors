// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-crypto-insecure-iv@v1.0 defects=0}
import { createReadStream, createWriteStream } from 'fs';
import { scryptSync, createCipheriv } from 'crypto';
import dotenv from 'dotenv'; dotenv.config();
import { randomBytes, scryptSync, createCipheriv, createReadStream, createWriteStream } from 'crypto';

function compliant(): void {
    const algorithm: string = 'aes-256-cbc';
    const password: string = process.env.ENCRYPTION_PASSWORD;
    const key: Buffer = scryptSync(password, 'salt', 24);
    // Compliant: Using a random IV helps to prevent a dictionary attack.
    const iv: Buffer = randomBytes(16);

    const decipher = createCipheriv(algorithm, key, iv);

    const input = createReadStream('test.enc');
    const output = createWriteStream('test.js');
    input.pipe(decipher).pipe(output);
}
// {/fact}
