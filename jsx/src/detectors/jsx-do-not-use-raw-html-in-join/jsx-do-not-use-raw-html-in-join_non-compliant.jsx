// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-do-not-use-raw-html-in-join@v1.0 defects=1}
function noncompliant(data) {
    // Noncompliant: Raw HTML is used directly in `join()`, which could lead to XSS if `data` is untrusted.
    let html = ["<span class=\"someclass\">", data, "</span>"].join()
}
// {/fact}
