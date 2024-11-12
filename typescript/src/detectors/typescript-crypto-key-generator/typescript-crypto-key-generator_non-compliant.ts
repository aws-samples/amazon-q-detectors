// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-crypto-key-generator@v1.0 defects=1}
import crypto from 'crypto';

function cryptographicKeyGeneratorNoncompliant() {
    var object = {
        // Noncompliant: `modulusLength` is less than 2048 bits.
        modulusLength: 1024,
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
    };
    var { publicKey, privateKey } = crypto.generateKeyPairSync('rsa', object);
}
// {/fact}
