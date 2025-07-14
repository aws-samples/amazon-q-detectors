// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-unsafe@v1.0 defects=0}
package main

import (
	"fmt"
)

func compliant() {
	s := "hello"
	
	// Compliant: Using standard Go features maintains memory safety.
	p := &s
	fmt.Println(p)
}
// {/fact}
