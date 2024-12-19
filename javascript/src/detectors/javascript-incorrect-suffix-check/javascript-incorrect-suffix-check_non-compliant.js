// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-incorrect-suffix-check@v1.0 defects=1}
function nonCompliant(bigStr, smallStr) {
    // Noncompliant: Improper input validation.
    return bigStr.indexOf(smallStr) === bigStr.length - smallStr.length;
}
// {/fact}
