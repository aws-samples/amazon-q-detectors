// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-incorrect-suffix-check@v1.0 defects=0}
function compliant(bigStr, smallStr) {
    // Compliant: Proper input validation.
    return bigStr.length >= smallStr.length && bigStr.indexOf(smallStr) === bigStr.length - smallStr.length; 
}
// {/fact}
