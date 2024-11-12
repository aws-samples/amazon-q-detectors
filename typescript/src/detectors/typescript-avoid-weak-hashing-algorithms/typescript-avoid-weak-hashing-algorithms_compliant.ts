// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-weak-hashing-algorithms@v1.0 defects=0}
import crypto from 'crypto';

function insecureHashingCompliant()
{
    // Compliant: `SHA-256` is secure hash algorithm.
    var secure_hash_algo = 'SHA-256';
    crypto.createHash(secure_hash_algo);
}
// {/fact}
