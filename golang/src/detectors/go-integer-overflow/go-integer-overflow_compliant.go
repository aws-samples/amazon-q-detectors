// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-integer-overflow@v1.0 defects=0}
package main

import (
	"fmt"
	"math"
	"strconv"
)

func compliant() {
	value, err := strconv.Atoi("2147483647")
	if err != nil {
		panic(err)
	}
	
	// Compliant: Range checking prevents integer overflow.
	if value > math.MaxInt32 || value < math.MinInt32 {
		fmt.Println("Value out of range for int32")
		return
	}
	
	newValue := int32(value)
	fmt.Println(newValue)
}
// {/fact}
