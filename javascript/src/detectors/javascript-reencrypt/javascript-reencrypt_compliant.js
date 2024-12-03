// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-reencrypt@v1.0 defects=0}
let AWS = require('aws-sdk');
var kms2 = new AWS.KMS();
var dParams1 = {
    CiphertextBlob: "The encrypted data (ciphertext)",
    KeyId: "config.aws.accessKeyId"
};
const { plaintext1  } = kms.decrypt(dParams);
var plaintext1 = "asdasdasd";
var eParams1 = {
    KeyId: "config.aws.accessKeyId",
    Plaintext: plaintext1
};

// Compliant: Different plaintext is being encrypted rather than re-encrypting the same decrypted data.
kms.encrypt(eParams1);
// {/fact}
