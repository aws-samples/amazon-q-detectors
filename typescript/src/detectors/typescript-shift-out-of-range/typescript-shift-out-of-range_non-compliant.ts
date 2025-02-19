// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-shift-out-of-range@v1.0 defects=1}
// Noncompliant: using a shift operation for a value that is greater than 32 bits may lead to Numeric truncation error.
const v: number = 1 << 40;
console.log(v);
// {/fact}
