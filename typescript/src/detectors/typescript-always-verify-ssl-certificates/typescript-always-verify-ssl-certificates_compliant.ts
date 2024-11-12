// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-always-verify-ssl-certificates@v1.0 defects=0}
import * as tls from 'tls';
import * as fs from 'fs';

function improperCertificateValidationCompliant() {
    var options = {
        host: 'encrypted.example.com',
        // Compliant: SSL certificates are properly configured by providing both `key` and `cert` files for TLS server creation.
        key: fs.readFileSync('keys/client-key.pem'),
        cert: fs.readFileSync('keys/client-cert.pem')
    };

    tls.createServer(options, (socket: tls.TLSSocket) => {
        socket.write('HTTP/1.1 200 OK\r\n');
        socket.write('Content-Type: text/plain\r\n');
        socket.write('\r\n');
        socket.write('Welcome!');
        socket.end();
    }).listen(8000);
}
// {/fact}
