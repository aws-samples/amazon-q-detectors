// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package insecuregrpc

// {fact rule=go-grpc-server-insecure-connection@v1.0 defects=0}
import (
	"crypto/x509"
	"log"
	"net"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials"
)

func grpcServerInsecureConnectionCompliant(listener net.Listener, cp *x509.CertPool) {
	creds := grpc.Creds(credentials.NewClientTLSFromCert(cp, ""))
	// Compliant: Credentials are passed to `grpc.NewServer()`.
	d := grpc.NewServer(creds)
	err := d.Serve(listener)
	if err != nil {
		log.Println(err)
		return
	}
}
// {/fact}
