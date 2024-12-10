// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-all-interfaces-socket-binding@v1.0 defects=0}
var dgram = require('dgram');
const PORT = 50007;
const HOST = '139.123.123.123' // conformant
const server = dgram.createSocket('udp4');

server.on('listening', function() {
    var address = server.address();
    console.log('UDP Server listening on ' + address.address + ':' + address.port);
});

// Compliant: Socket explicitly binds to a specific IP address rather than all network interfaces, limiting network exposure.
server.bind(PORT, HOST);
// {/fact}
