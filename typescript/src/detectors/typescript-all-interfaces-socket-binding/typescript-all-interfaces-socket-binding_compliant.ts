// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-all-interfaces-socket-binding@v1.0 defects=0}
import http from 'http';

function allInterfacesSocketBindingCompliant() {
    // Compliant: Binding to a specific IP address for security.
    const host = '127.0.0.1';
    const port = 8080;

    const server = http.createServer();

    server.listen(port, host, () => {
        console.log(`Listening on port: ${port} and host: ${host}`);
    });
}
// {/fact}
