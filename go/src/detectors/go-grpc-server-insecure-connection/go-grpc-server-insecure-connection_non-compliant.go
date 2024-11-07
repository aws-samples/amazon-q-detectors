// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package insecuregrpc

// {fact rule=go-grpc-server-insecure-connection@v1.0 defects=1}
import (
	"log"
	"net"

	"google.golang.org/grpc"
)

func grpcServerInsecureConnectionNoncompliant(listener net.Listener) {
	// Noncompliant: Credentials are not passed to `grpc.NewServer()`.
	d := grpc.NewServer()
	err := d.Serve(listener)
	if err != nil {
		log.Println(err)
		return
	}
}
// {/fact}
