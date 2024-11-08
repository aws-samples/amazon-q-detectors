// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-origins-verified-cross-origin-communication@v1.0 defects=0}
function originsVerifiedCrossOriginCommunicationsCompliant() {
    var iframe = document.getElementsByClassName(".testiframe")
    // Compliant: Using secure origin.
    iframe.contentWindow.postMessage("secret_value", "https://secure.example.com")
}
// {/fact}
