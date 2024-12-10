// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-all-interfaces-socket-binding@v1.0 defects=1}
var dgram = require('dgram');
const port_4 = 50007;
var host = ''
const server = dgram.createSocket('udp4');

server.on('listening', function() {
    var address = server.address();
    console.log('UDP Server listening on ' + address.address + ':' + address.port);
});

// Noncompliant: Empty host value allows binding to all network interfaces, potentially exposing the UDP server to unauthorized network access.
server.bind(port_4, host);
// {/fact}