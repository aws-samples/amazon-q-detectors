// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-https-connection-pool@v1.0 defects=0}
var https = require('https');

function compliant() {
    const keepAliveAgent = new https.Agent({ keepAlive: true });
    options.agent = keepAliveAgent;

    // Noncompliant: HTTPS is used instead of plain HTTP leading to a secure connection.
    https.request(options, onResponseCallback);
}// {/fact}
