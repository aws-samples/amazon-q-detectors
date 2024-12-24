// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-pseudorandom-number-generators@v1.0 defects=1}
import crypto from 'crypto';

function nonCompliant(): void {
    const salt = crypto.randomInt(0, 1000000000); 

    // Noncompliant: Using weak salt generation.
    crypto.pbkdf2('secret', salt, 100000, 64, 'sha512', (err: Error | null, derivedKey: Buffer) => {
        if (err) throw err;
        console.log(derivedKey.toString('hex'));
    });
}
// {/fact}
