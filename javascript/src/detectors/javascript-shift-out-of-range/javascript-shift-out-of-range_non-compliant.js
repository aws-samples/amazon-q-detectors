// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-shift-out-of-range@v1.0 defects=1}
const a = 5;
const b = 45;

// Noncompliant: Shift operations with values more than 32 can lead to unexpected results.
console.log(a << b);
// {/fact}
