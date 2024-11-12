// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-integer-overflow@v1.0 defects=0}
function integerOverflowCompliant() {
    // Compliant: Using `BigInt()` prevents integer overflow by handling arbitrarily large integers safely.
    var max: BigInt = BigInt(154327115334273650000012748329);
}
// {/fact}
