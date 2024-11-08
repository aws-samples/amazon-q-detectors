// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-integer-overflow@v1.0 defects=1}
function integerOverflowNoncompliant() {
    // Noncompliant: Assigning a value that exceeds the safe integer range, leading to potential overflow.
    var max = 154327115334273650000012748329
}
// {/fact}
