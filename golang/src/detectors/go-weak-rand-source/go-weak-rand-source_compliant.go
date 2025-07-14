// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-weak-rand-source@v1.0 defects=0}
package main

import (
	"crypto/rand"
	"encoding/base64"
)

func compliant() string {
	// Compliant: Using `crypto/rand` is cryptographically secure.
	token := make([]byte, 32)
	_, err := rand.Read(token)
	if err != nil {
		return ""
	}
	
	return base64.StdEncoding.EncodeToString(token)
}
// {/fact}
