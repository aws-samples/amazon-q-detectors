// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-hardcoded-ip-address@v1.0 defects=1}
import net, { Socket, Server } from 'net';

const client: Socket = new Socket();

function nonCompliant(): void {
    // Noncompliant: IP address literal is hard-coded.
    let ip: string = "192.168.12.42";
    client.connect(80, ip, function(): void {
        // Connection callback
    });
}

// {/fact}
