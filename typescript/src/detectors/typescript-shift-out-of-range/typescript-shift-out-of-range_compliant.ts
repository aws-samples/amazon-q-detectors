// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-shift-out-of-range@v1.0 defects=0}
// Compliant: Using standard library functions such as `Math.pow` to perform the required shifting helps to prevent Numeric truncation error.
const v: number = Math.pow(2, 40);
console.log(v);
// {/fact}
