// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-detect-insecure-websocket@v1.0 defects=0}

// Compliant: Use of the wss:// scheme for WebSocket connections, which securely encrypts the transmitted data.
let socket: WebSocket = new WebSocket("wss://javascript.org/article/websocket/demo/hello");
socket.onopen = function(e: Event): void {
    alert("[open] Connection established");
    alert("Sending to server");
    socket.send("My name is John");
};
// {/fact}
