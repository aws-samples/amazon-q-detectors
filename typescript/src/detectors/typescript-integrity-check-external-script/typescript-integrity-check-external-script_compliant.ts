// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-integrity-check-external-script@v1.0 defects=0}
function untrustedDeserializationCompliant() {
    var script = document.createElement("script");
    script.src = "https://example.com/script.js";
    // Compliant: Integrity is checked.
    script.integrity = "sha384-oqVuAfXRKap7fdgcCY5uykM6+R9GqQ8K/uxy9rx7HNQlGYl1kPzQho1wx4JwY8wC";
    document.head.appendChild(script);
}
// {/fact}
