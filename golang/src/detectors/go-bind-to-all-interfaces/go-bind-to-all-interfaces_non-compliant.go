// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-bind-to-all-interfaces@v1.0 defects=1}
package main

import (
	"net"
)

func noncompliant() {
	// Noncompliant: Binding to all interfaces exposes service to unintended traffic.
	tel, _ := net.Listen("tcp", "0.0.0.0:2000")
	defer tel.Close()
}
// {/fact}
