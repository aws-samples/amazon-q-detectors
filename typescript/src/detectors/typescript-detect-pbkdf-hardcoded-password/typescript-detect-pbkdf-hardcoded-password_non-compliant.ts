// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-detect-pbkdf-hardcoded-password@v1.0 defects=1}
import crypto from 'crypto';

function nonCompliant() {
    function hardcodedCredentialsNoncompliant(salt: Buffer | string, iterations: number, keyLen: number, digest: string) {
        // Noncompliant: `password` is hardcoded directly in the code instead of being retrieved from secure storage or environment variables.
        crypto.pbkdf2('password', salt, iterations, keyLen, digest, (err: Error | null, key: Buffer) => {
            if (err) {
                throw err;
            }
            return key.toString('base64');
        });
    }
}
// {/fact}
