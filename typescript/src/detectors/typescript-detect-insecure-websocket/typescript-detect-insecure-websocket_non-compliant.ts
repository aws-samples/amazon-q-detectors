// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-detect-insecure-websocket@v1.0 defects=1}

// Noncompliant: Use of the ws:// scheme for WebSocket connections, which is insecure.
var scheme   = "ws://";
	 var uri      = scheme + window.document.location.host + "/";
	 var ws       = new WebSocket(uri);
	 ws.onmessage = function(message) {}
// {/fact}
