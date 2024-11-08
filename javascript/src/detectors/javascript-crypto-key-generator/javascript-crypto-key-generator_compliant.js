// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-crypto-key-generator@v1.0 defects=0}
function cryptographicKeyGeneratorCompliant()
{
    var crypto = require("crypto")
    var object = {
        // Compliant: `modulusLength` is 2048 bits, ensuring adequate cryptographic strength.
        modulusLength: 2048,
        publicKeyEncoding: {
            type: 'spki',
            format: 'pem'
        },
        privateKeyEncoding: {
            type: 'pkcs8',
            format: 'pem',
            cipher: 'aes-256-cbc',
            passphrase: 'top secret'
        }
    }
    var { publicKey, privateKey} = crypto.generateKeyPairSync('rsa', object)
}
// {/fact}
