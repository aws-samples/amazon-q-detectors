// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-hash-algo-compliance-check-for-pbkdf2@v1.0 defects=1}
let crypto=require('crypto')

function nonCompliant(salt,iterations,keylen)
{
    // Noncompliant: Weak hashing algorithm (md5) is used.
    crypto.pbkdf2('password', salt, iterations, keylen, 'md5', function (err, derivedKey) {
        if (err) throw err;

        // Log the derived key for verification
        console.log(`Derived key: ${derivedKey.toString('hex')}`);
    });

}
// {/fact}
