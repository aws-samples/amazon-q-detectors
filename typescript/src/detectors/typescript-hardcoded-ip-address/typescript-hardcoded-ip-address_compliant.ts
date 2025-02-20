// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-hardcoded-ip-address@v1.0 defects=0}
import { Socket } from 'net';

function compliant(): void {
    // Compliant: IP address literal is not hardcoded
    const ip_add: string = process.env["IP"];
    const client: Socket = new Socket();
    
    client.connect(80, ip_add, function(): void {
    });
}

// {/fact}
