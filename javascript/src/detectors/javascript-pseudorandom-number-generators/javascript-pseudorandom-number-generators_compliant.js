// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-pseudorandom-number-generators@v1.0 defects=0}
const crypto = require('crypto');

function compliant(){
    var salt = crypto.randomBytes(32);

    // Compliant: Using `crypto.randomBytes` produces a strong cryptographic key.
    crypto.pbkdf2('secret', salt, 100000, 64, 'sha512',  (err, derivedKey) => {
        if (err)
            throw err;
        console.log(derivedKey.toString('hex'));
    });
}
// {/fact}
