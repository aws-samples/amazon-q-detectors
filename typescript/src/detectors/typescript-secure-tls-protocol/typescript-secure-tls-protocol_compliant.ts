// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-secure-tls-protocol@v1.0 defects=0}
import * as tls from 'tls';

function compliant(): void {
    let options: tls.ConnectionOptions = {
        secureProtocol: 'TLSv1_2_method'
    };
    // Compliant: Using secure `TLS 1.2` protocol, which provides strong encryption and security for network communications.
    tls.connect(443, "www.example.com", options, () => { });
}
// {/fact}