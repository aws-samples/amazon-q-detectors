// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-integer-overflow@v1.0 defects=1}
function integerOverflowNoncompliant() {
    // Noncompliant: The bigint is assigned to a variable without using `BigInt()`, causing potential integer overflow.
    var max = 154327115334273650000012748329;
}
// {/fact}
