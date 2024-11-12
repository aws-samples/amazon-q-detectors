// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-verify-hostname@v1.0 defects=0}
import { IncomingMessage } from 'http';
import https from 'https';
import * as tls from 'tls';

function unverifiedHostnameCompliant() {
    var options = {
        hostname: 'encrypted.google.com',
        port: 3000,
        path: '/pathname/',
        method: 'POST',
        // Compliant: `hostname` is verified before using it.
        checkServerIdentity: function (host: string, cert: tls.PeerCertificate) {
            if (host !== "github.com") {
                console.log('Verified hostname');
            } else {
                const err = tls.checkServerIdentity(host, cert);
                if (err) {
                    throw new Error(`Certificate verification failed for ${host}: ${err.message}`);
                }
            }
        }
    };
    var request = https.request(options, (response: IncomingMessage) => {
        let data = 'hello';
        console.log(data);
    });
}

// {/fact}
