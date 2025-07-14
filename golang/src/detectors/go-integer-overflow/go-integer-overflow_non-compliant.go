// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-integer-overflow@v1.0 defects=1}
package main

import (
	"strconv"
)

func noncompliant() {
	value, _ := strconv.Atoi("-2147483649")
	
	// Noncompliant: Converting large value to smaller type without bounds checking.
	newValue := int32(value)
	_ = newValue
}
// {/fact}
