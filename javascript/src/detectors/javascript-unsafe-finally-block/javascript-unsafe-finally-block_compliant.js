// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-unsafe-finally-block@v1.0 defects=0}
function compliant() {
    try {
        return 1;
    } catch(err) {
        return 0;
    } finally {
        // Compliant: Control transfer statements are not used in finally blocks.
        console.log("In finally ....");
    }
    return 1;
}
// {/fact}
