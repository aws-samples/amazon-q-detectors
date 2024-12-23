// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-integrity-check-external-script@v1.0 defects=1}
function nonCompliant() {
    // Noncompliant: Missing hash of the external script in the `integrity` attribute, need to improve security.
    let script = document.createElement("script");
    script.src = "https://cdnexample.com/script-latest.js";
    script.crossOrigin = "anonymous";
    document.head.appendChild(script);
}
// {/fact}
