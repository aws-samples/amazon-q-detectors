/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package crypto

// {fact rule=go-weak-crypto@v1.0 defects=0}
import (
	"crypto/sha256"
	"fmt"
	"io"
	"os"
)

func secureHashingCompliant() {
	file, err := os.Open("example.txt")
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	defer file.Close()

	// Compliant: Using `SHA-256`, which is a secure cryptographic hash function.
	hash := sha256.New()
	if _, err := io.Copy(hash, file); err != nil {
		fmt.Println("Error hashing file:", err)
		return
	}

	fmt.Printf("SHA-256 checksum: %x\n", hash.Sum(nil))
}
// {/fact}
