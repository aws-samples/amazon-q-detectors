// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-pseudorandom-number-generators@v1.0 defects=1}
const crypto = require('crypto');

function nonCompliant(){
    const salt = crypto.randomInt(0, 1000000000);

    // Noncompliant: Usage of `crypto.randomInt`, could lead to weak cryptographic keys.
    crypto.pbkdf2('secret', salt, 100000, 64, 'sha512', (err, derivedKey) => {
        if (err)
            throw err;
        console.log(derivedKey.toString('hex'));
    });
}// {/fact}
