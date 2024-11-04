/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package weak_key_strength

// {fact rule=go-weak-key-strength@v1.0 defects=1}
import (
	"crypto/rand"
	"crypto/rsa"
	"fmt"
)

func weakKeyStrengthNoncompliant() {
	// Noncompliant: Generating `RSA` key less than `2048` bits.
	privateKey, err := rsa.GenerateKey(rand.Reader, 1024)
	if err != nil {
		fmt.Printf("Failed to generate private key: %v\n", err)
	}
	fmt.Println(privateKey)
}
// {/fact}
