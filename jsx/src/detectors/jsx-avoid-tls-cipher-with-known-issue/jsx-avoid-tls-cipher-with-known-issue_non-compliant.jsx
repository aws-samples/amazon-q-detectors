// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-avoid-tls-cipher-with-known-issue@v1.0 defects=1}
function noncompliant()
{
    var ciphers = [`TLS_DH_anon_WITH_AES_256_GCM_SHA384`,
        `TLS_AES_128_GCM_SHA256`,
        `ECDHE-ECDSA-AES128-GCM-SHA256`].join(':')
    var options = {
        hostname: 'www.example.com',
        port: 443,
        path: '/',
        method: 'GET',
        secureProtocol: 'TLSv1_2_method',
        // Noncompliant: Insecure TLS cipher suite is used.
        ciphers:ciphers
    }

    var req = https.request(options, (res) => {
        res.on('data', (d) => {
            process.stdout.write(d)
        })
    })
}
// {/fact}
