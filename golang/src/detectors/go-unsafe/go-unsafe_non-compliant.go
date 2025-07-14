// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-unsafe@v1.0 defects=1}
package main

import (
	"fmt"
	"unsafe"
)

func noncompliant() {
	s := "hello"
	
	// Noncompliant: Using unsafe package bypasses Go's memory safety guarantees.
	p := unsafe.Pointer(&s)
	fmt.Println(p)
}
// {/fact}
