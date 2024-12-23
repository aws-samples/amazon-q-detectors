// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-hash-algo-compliance-check-for-pbkdf2@v1.0 defects=1}

import crypto from 'crypto';

function nonCompliant(salt: string, iterations: number, keylen: number): void {
    // Noncompliant: Weak hashing algorithm (md5) is used.
    crypto.pbkdf2('password', salt, iterations, keylen, 'md5', (err: Error | null, derivedKey: Buffer) => {
        if (err) throw err;

        console.log(`Derived key: ${derivedKey.toString('hex')}`);
    });
}

// {/fact}
