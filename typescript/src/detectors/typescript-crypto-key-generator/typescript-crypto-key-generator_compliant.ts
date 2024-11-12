// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-crypto-key-generator@v1.0 defects=0}
import crypto from 'crypto';

function cryptographicKeyGeneratorCompliant() {
    var object = {
        // Compliant: `modulusLength` is 2048 bits.
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
    };
    var { publicKey, privateKey } = crypto.generateKeyPairSync('rsa', object);
}
// {/fact}
