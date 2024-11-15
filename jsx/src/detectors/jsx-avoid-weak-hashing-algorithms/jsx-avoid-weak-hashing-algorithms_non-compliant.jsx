// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-avoid-weak-hashing-algorithms@v1.0 defects=1}
var crypto = require('crypto')
function noncompliant()
{
    // Noncompliant: `md5` is weak hash algorithm.
    var insecure_hash_algo = 'md5'
    crypto.createHash(insecure_hash_algo)
}
// {/fact}
