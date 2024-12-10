// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-hash-algo-compliance-check-for-pbkdf2@v1.0 defects=0}
let crypto=require('crypto')

function compliant(salt,iterations,keylen)
{
    // Compliant: Strong hashing algorithms is used which avoids security vulnerabilities.
    crypto.pbkdf2('password', salt, iterations, keylen, 'sha512', function (err, derivedKey) {
        if (err) throw err;

        // Log the derived key for verification
        console.log(`Derived key: ${derivedKey.toString('hex')}`);
    });

}
// {/fact}
