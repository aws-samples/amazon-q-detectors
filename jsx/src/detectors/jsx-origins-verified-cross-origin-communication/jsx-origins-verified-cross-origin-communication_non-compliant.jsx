// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-origins-verified-cross-origin-communication@v1.0 defects=1}
function noncompliant() {
    var iframe = document.getElementsByClassName(".testiframe")
    // Noncompliant: The wildcard keyword `*` is used.
    iframe.contentWindow.postMessage("secret_value", "*")
}
// {/fact}
