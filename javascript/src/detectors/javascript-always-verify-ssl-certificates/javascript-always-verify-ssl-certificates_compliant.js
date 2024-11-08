// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-always-verify-ssl-certificates@v1.0 defects=0}
var tls = require("tls")
var fs = require("fs")

function improperCertificateValidationCompliant() {
    var options = {
        host: 'encrypted.example.com',
        // Compliant: SSL certificate provided to ensure secure connection.
        key: fs.readFileSync('keys/client-key.pem'),
        cert: fs.readFileSync('keys/client-cert.pem')
    }

    tls.createServer(options, (req, res) => {
        res.writeHead(200)
        res.end()
    }).listen(8000)
}
// {/fact}
