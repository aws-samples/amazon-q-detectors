// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-integrity-check-external-script@v1.0 defects=1}
function untrustedDeserializationNoncompliant() {
    var script = document.createElement("script");
    script.src = "https://example.com/script.js";
    // Noncompliant: Integrity is not checked.
    document.head.appendChild(script);
}
// {/fact}
