// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package go_deprecated_key_generator

// {fact rule=go-deprecated-key-generator@v1.0 defects=0}
import (
	"crypto/rand"
	"crypto/rsa"
	"fmt"
)

func deprecatedKeyGeneratorCompliant() {
	// Compliant: Generated private key with proper method.
	pvk, err := rsa.GenerateKey(rand.Reader, 2048)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(pvk)
}
// {/fact}
