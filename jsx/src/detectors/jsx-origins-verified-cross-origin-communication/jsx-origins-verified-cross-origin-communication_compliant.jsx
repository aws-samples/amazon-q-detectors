// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-origins-verified-cross-origin-communication@v1.0 defects=0}
function compliant() {
    var iframe = document.getElementsByClassName(".testiframe")
    // Compliant: Using secure origin.
    iframe.contentWindow.postMessage("secret_value", "https://secure.example.com")
}
// {/fact}
