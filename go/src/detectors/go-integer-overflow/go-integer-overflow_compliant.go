// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package main

// {fact rule=go-integer-overflow@v1.0 defects=0}
import (
	"fmt"
	"strconv"
)

func integerOverflowCompliant() {
	value, err := strconv.Atoi("2147483647")
	if err != nil {
		panic(err)
	}
	// Compliant: `int32` used with small value.
	newValue := int32(value)
	fmt.Println(newValue)
}
// {/fact}
