// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-unsafe-finally-block@v1.0 defects=1}
function noncompliant() {
    try {
        console.log("Trying to connect to the server");
    } catch(err) {
        console.log("Error: " + err);
        return 0;
    } finally {
        // Noncompliant: Control transfer statements are used in finally blocks.
        console.log("In finally ....");
        return 0;
    }
    return 1;
}
// {/fact}
