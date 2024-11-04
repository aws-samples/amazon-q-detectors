/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package tls_version

// {fact rule=go-tls-version@v1.0 defects=0}
import (
	"crypto/tls"
)

func tlsVersionCompliant() {
	config := &tls.Config{}
	// Compliant: `TLS 1.3` is a secure version of the protocol.
	config.MinVersion = tls.VersionTLS13
}
// {/fact}
