// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package tls_version

// {fact rule=go-tls-version@v1.0 defects=1}
import (
	"crypto/tls"
)

func tlsVersionNoncompliant() {
	config := &tls.Config{}
	// Noncompliant: `SSL 3.0` is a non-secure version of the protocol.
	config.MinVersion = tls.VersionSSL30
}
// {/fact}
