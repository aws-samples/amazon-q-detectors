// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-detect-pbkdf-hardcoded-password@v1.0 defects=0}
import crypto from 'crypto';

function compliant() {
    function hardcodedCredentialsCompliant(salt: Buffer | string, iterations: number, keyLen: number, digest: string) {
        // Compliant: `password` is securely obtained from environment variables instead of being hardcoded in the code.
        crypto.pbkdf2(process.env.password, salt, iterations, keyLen, digest, (err: Error | null, key: Buffer) => {
            if (err) {
                throw err;
            }
            return key.toString('base64');
        });
    }
}
// {/fact}
