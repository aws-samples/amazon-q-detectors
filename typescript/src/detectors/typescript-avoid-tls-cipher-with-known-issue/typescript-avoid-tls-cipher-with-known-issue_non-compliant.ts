// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-avoid-tls-cipher-with-known-issue@v1.0 defects=1}
import https from 'https';
import { IncomingMessage } from 'http';

function insecureCryptographyNoncompliant()
{
    var ciphers = [`TLS_DH_anon_WITH_AES_256_GCM_SHA384`,
        `TLS_AES_128_GCM_SHA256`,
        `ECDHE-ECDSA-AES128-GCM-SHA256`].join(':');
    var options = {
        hostname: 'www.example.com',
        port: 443,
        path: '/',
        method: 'GET',
        secureProtocol: 'TLSv1_2_method',
        // Noncompliant: Insecure TLS cipher suite is used.
        ciphers: ciphers
    };
    var req = https.request(options, (res: IncomingMessage) => {
        res.on('data', (d: Buffer) => {
            process.stdout.write(d);
        });
    });
}
// {/fact}
