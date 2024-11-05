// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package weak_key_strength

// {fact rule=go-weak-key-strength@v1.0 defects=0}
import (
	"crypto/rand"
	"crypto/rsa"
	"fmt"
)

func weakKeyStrengthCompliant() {
	// Compliant: Generating `RSA` key of `2048` bits.
	privateKey, err := rsa.GenerateKey(rand.Reader, 2048)
	if err != nil {
		fmt.Printf("Failed to generate private key: %v\n", err)
	}
	fmt.Println(privateKey)
}
// {/fact}
