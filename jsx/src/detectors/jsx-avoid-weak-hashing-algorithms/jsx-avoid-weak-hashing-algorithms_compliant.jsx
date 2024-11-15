// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-avoid-weak-hashing-algorithms@v1.0 defects=0}
var crypto = require('crypto')
function compliant()
{
    // Compliant: Utilized `SHA-256` as a secure hashing algorithm.
    var secure_hash_algo = 'SHA-256'
    crypto.createHash(secure_hash_algo)
}
// {/fact}
