// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package go_deprecated_key_generator

// {fact rule=go-deprecated-key-generator@v1.0 defects=1}
import (
	"crypto/rand"
	"crypto/rsa"
	"fmt"
)

func deprecatedKeyGeneratorNoncompliant() {
	// Noncompliant: Generated private key with deprecated method.
	pvk, err := rsa.GenerateMultiPrimeKey(rand.Reader, 3, 2048)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(pvk)
}
// {/fact}
