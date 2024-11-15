// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-integer-overflow@v1.0 defects=1}
function noncompliant() {
    // Noncompliant: Assigning a value that exceeds the safe integer range, leading to potential overflow.
    var max = 154327115334273650000012748329
}
// {/fact}
