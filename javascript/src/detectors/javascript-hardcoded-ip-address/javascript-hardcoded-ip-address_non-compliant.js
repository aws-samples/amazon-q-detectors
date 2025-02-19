// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-hardcoded-ip-address@v1.0 defects=1}
const net = require('net');
const ip = require('ip');

const client = new net.Socket();

function nonCompliant() {
    // Noncompliant: Hard-coded IP address used.
    const hardcodedIp = "192.168.12.42";

    client.connect(80, hardcodedIp, function () {
        console.log(`Connected to ${hardcodedIp}`);
    });
}
// {/fact}
