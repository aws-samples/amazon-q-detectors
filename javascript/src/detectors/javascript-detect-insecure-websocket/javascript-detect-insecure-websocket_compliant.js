// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-detect-insecure-websocket@v1.0 defects=0}
// Use of the ws:// scheme for WebSocket connections, which is iinsecure.
let socket = new WebSocket("wss://javascript.org/article/websocket/demo/hello");
socket.onopen = function(e) {
    alert("[open] Connection established");
    alert("Sending to server");
    socket.send("My name is John");
};
// {/fact}
