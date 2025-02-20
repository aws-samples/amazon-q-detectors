// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-hash-algo-compliance-check-for-pbkdf2@v1.0 defects=0}
import crypto from 'crypto';

function compliant(salt: string, iterations: number, keylen: number): void {
    // Compliant: Strong hashing algorithm (SHA-512) is used which avoids security vulnerabilities.
    crypto.pbkdf2('password', salt, iterations, keylen, 'sha512', (err: Error | null, derivedKey: Buffer) => {
        if (err) throw err;

        console.log(`Derived key: ${derivedKey.toString('hex')}`);
    });
}
// {/fact}
