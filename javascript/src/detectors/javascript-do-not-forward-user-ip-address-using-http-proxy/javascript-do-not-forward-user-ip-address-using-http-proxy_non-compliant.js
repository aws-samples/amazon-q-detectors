// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-forward-user-ip-address-using-http-proxy@v1.0 defects=1}
const httpProxy = require('http-proxy');
const http = require('http');

function nonCompliant() {

    // Noncompliant: The `xfwd` option in http-proxy enables forwarding of certain headers which can create security risks.
    const proxyServer = http.createServer(function(req, res) {
        const proxyMocks = httpProxy.createProxyServer({
            target: {
                host: '127.0.0.1',
                port: 5439,
            },
            xfwd: true
        });
    });

}
// {/fact}
