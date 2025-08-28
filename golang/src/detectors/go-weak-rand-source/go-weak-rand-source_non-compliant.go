// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-weak-rand-source@v1.0 defects=1}
package main

import (
	"crypto/rsa"
	"math/rand"
	"time"
)

func noncompliant() {
	// Noncompliant: Using `math/rand` for cryptographic purposes.
	rand.Seed(time.Now().UnixNano())
	
	key := make([]byte, 32)
	rand.Read(key)
	
	_ = key
}
// {/fact}
