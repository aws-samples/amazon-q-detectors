// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-dom-based-open-redirection@v1.0 defects=1}
function crossSiteScriptingNoncompliant() {
    let url = window.location.search.slice(1);
    // Noncompliant: Unsafe jQuery `ajax` request.
    $.ajax({ url: url, data: "Hello" });
}
// {/fact}
