// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-secure-tls-protocol@v1.0 defects=0}
var tls= require('tls')

function compliant(){
    let options = {
        secureProtocol: 'TLSv1_2_method'
    };
    // Compliant: Using secure `TLS 1.2` protocol, which provides strong encryption and security for network communications.
    tls.connect(443, "www.example.com", options, () => { });
}
// {/fact}
