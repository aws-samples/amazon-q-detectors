// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-bind-to-all-interfaces@v1.0 defects=0}
package main

import (
	"net"
)

func compliant() {
	// Compliant: Specific IP address restricts access to intended interface.
	tel, _ := net.Listen("tcp", "192.168.1.101:2000")
	defer tel.Close()
}
// {/fact}
