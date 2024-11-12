// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-verify-hostname@v1.0 defects=1}
import { IncomingMessage } from 'http';
import https from 'https';
import * as tls from 'tls';

function unverifiedHostnameNoncompliant() {
    var options = {
        hostname: 'encrypted.google.com',
        port: 3000,
        path: '/pathname/',
        method: 'POST',
        // Noncompliant: `hostname` is not verified.
        checkServerIdentity: function (host: string, cert: tls.PeerCertificate) {
            console.log('unverified hostname');
        }
    };
    var request = https.request(options, (response: IncomingMessage) => {
        let data = 'hello';
        console.log(data);
    });
}
// {/fact}
