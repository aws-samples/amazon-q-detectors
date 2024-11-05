// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package grpc_client

// {fact rule=go-grpc-client-insecure-connection@v1.0 defects=0}
import (
	"google.golang.org/grpc"
	"log"
)

func grpcClientInsecureConnectionCompliant(address string) {
	// Compliant: `grpc.WithInsecure()` is not used for GRPC client connections.
	d, err := grpc.Dial(address)
	if err != nil {
		log.Println(err)
		return
	}
	defer d.Close()
}
// {/fact}
