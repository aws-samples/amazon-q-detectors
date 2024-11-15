// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-always-verify-ssl-certificates@v1.0 defects=1}
var tls = require("tls")
var fs = require("fs")

function noncompliant() {
    var options = {
        host: 'encrypted.example.com',
        // Noncompliant: SSL certificate verification is disabled as `rejectUnauthorized` is set to `false`.
        rejectUnauthorized: false
    }

    tls.createServer(options, (req, res) => {
        res.writeHead(200)
        res.end()
    }).listen(8000)
}
// {/fact}
