// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-shift-out-of-range@v1.0 defects=0}
const a1 = 5;
const b1 = 30;

// Compliant: Shift operations with are safe to use with values less than 32.
console.log(a1 * Math.pow(2, b1));
// {/fact}
