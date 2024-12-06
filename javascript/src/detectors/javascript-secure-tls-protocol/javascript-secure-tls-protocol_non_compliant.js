// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-secure-tls-protocol@v1.0 defects=1}
var tls = require('tls');

function nonCompliant() {
    let options = {
        secureProtocol: 'TLSv1_method'  // Deprecated and insecure version of TLS
    };

    // Noncompliant: Using deprecated and insecure protocol instead of more secure `TLS 1.2` or higher versions.
    tls.connect(443, "www.example.com", options, () => {
        console.log('Connected to www.example.com using TLS 1.0 (insecure)');
    });
}
// {/fact}
