// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-always-verify-ssl-certificates@v1.0 defects=1}
import * as tls from 'tls';

function improperCertificateValidationNoncompliant() {
    var options = {
        host: 'encrypted.example.com',
        // Noncompliant: Setting `rejectUnauthorized` to `false` disables SSL certificate validation, exposing the application to MITM attacks.
        rejectUnauthorized: false
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
