// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-secure-tls-protocol@v1.0 defects=1}
import * as tls from 'tls';

function nonCompliant(): void {
    let options: tls.ConnectionOptions = {
        secureProtocol: 'TLSv1_method'
    };

    // Noncompliant: Using deprecated and insecure protocol instead of more secure `TLS 1.2` or higher versions.
    tls.connect(443, "www.example.com", options, () => {
        console.log('Connected to www.example.com using TLS 1.0 (insecure)');
    });
}
// {/fact}
