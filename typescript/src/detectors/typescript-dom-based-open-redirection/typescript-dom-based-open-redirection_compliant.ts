// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-dom-based-open-redirection@v1.0 defects=0}
import ESAPI from 'node-esapi';

function crossSiteScriptingCompliant() {
    let url = window.location.search.slice(1);
    // Compliant: `url` is sanitized before `ajax` call.
    url = ESAPI.encoder().encodeForURL(url);
    $.ajax({ url: url, data: "Hello" });
}
// {/fact}
