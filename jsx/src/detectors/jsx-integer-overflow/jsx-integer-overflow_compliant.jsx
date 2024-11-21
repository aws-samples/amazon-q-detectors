// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-integer-overflow@v1.0 defects=0}
function compliant() {
    // Compliant: `n` is appended to an integer which makes it a `bigint`.
    var max = 154327115334273650000012748329n
}
// {/fact}
