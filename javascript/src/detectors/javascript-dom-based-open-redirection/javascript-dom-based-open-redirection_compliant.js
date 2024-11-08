// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-dom-based-open-redirection@v1.0 defects=0}
const ESAPI = require('node-esapi')

function crossSiteScriptingCompliant() {
    let url = window.location.search.slice(1)
    // Compliant: URL is sanitized before `AJAX` call.
    url = ESAPI.encoder().encodeForURL(url)
    $.ajax({url: url, data: "Hello"})
}
// {/fact}
