// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-https-connection-pool@v1.0 defects=1}
var http = require('http');

function nonCompliant() {
    const keepAliveAgent = new http.Agent({ keepAlive: true });
    options.agent = keepAliveAgent;

    // Noncompliant: HTTP without TLS is used leading to an insecure connection.
    http.request(options, onResponseCallback);
}
// {/fact}
