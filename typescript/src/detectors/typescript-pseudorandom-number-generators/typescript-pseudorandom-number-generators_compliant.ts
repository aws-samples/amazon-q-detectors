// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-pseudorandom-number-generators@v1.0 defects=0}
import crypto from 'crypto';

function compliant(): void {
    // Compliant: Using cryptographically secure random bytes for salt
    const salt = crypto.randomBytes(16);  

    crypto.pbkdf2('secret', salt, 100000, 64, 'sha512', (err: Error | null, derivedKey: Buffer) => {
        if (err) {
            console.error('Error generating key:', err);
            throw err;
        }
        console.log(derivedKey.toString('hex'));
    });
}

// {/fact}
