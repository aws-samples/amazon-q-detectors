// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-hardcoded-ip-address@v1.0 defects=0}
const net = require('net');
const ip = require('ip');
const dotenv = require('dotenv');

dotenv.config();

const client = new net.Socket();

function compliant() {
    // Conformant: Retrieve IP address from environment variable
    const serverIp = process.env.SERVER_IP;

    if (!serverIp || !ip.isV4Format(serverIp)) {
        console.error('Invalid or missing IP address in environment variables.');
        return;
    }

    client.connect(80, serverIp, function () {
        console.log(`Connected to ${serverIp}`);
    });
}
// {/fact}
