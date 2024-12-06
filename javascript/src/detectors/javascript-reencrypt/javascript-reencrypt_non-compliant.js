// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-reencrypt@v1.0 defects=1}
const { KMS } = require('@aws-sdk/client-kms');
const kms = new KMS({
    accessKeyId: "accessKeyId",
    secretAccessKey: "secretAccessKey",
    region: "region",
});
var dParams1 = {
    CiphertextBlob: "The encrypted data (ciphertext)",
    KeyId: "config.aws.accessKeyId"
};
const { plaintext1  } = kms.decrypt(dParams1);
var eParams1 = {
    KeyId: "config.aws.accessKeyId",
    Plaintext: plaintext1
};

// Noncompliant: Immediately re-encrypting decrypted data with the same KMS key creates unnecessary cryptographic operations and potential security risks.
kms.encrypt(eParams1);
// {/fact}
