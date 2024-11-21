// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-all-interfaces-socket-binding@v1.0 defects=1}
import http from 'http';

function allInterfacesSocketBindingNoncompliant() {
    const server = http.createServer();

    // Noncompliant: Binding to an empty host and port, which defaults to all interfaces `(0.0.0.0)`.
    server.listen('', '', () => {
        console.log('Listening to port: and host:');
    });
}
// {/fact}
