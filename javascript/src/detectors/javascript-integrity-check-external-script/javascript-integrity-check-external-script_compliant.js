// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-integrity-check-external-script@v1.0 defects=0}
function compliant() {
    // Compliant: Hash of the external script in the `integrity` attribute has been provided which improves security.
    let script = document.createElement("script");
    script.src = "https://cdnexample.com/script-latest.js";
    script.crossOrigin = "anonymous";
    script.integrity = "sha384-OgVRvuATP1z7JjSMNlGrBJ0K/HDOIrtx8XuJbT5rI5R1RYc47Wl76t1ZklNQxQ7T"; // Add integrity hash
    document.head.appendChild(script);
}
// {/fact}
