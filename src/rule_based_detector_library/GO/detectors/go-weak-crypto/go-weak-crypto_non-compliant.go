// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package crypto

// {fact rule=go-weak-crypto@v1.0 defects=1}
import (
	"crypto/md5"
	"fmt"
	"io"
	"os"
)

func insecureHashingNoncompliant() {
	file, err := os.Open("example.txt")
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	defer file.Close()

	// Noncompliant: Using `MD5`, which is considered insecure due to collision vulnerabilities.
	hash := md5.New()
	if _, err := io.Copy(hash, file); err != nil {
		fmt.Println("Error hashing file:", err)
		return
	}

	fmt.Printf("MD5 checksum: %x\n", hash.Sum(nil))
}
// {/fact}
