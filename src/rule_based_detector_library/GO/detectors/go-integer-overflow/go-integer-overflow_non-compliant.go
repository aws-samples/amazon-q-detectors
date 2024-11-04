/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package main

// {fact rule=go-integer-overflow@v1.0 defects=1}
import (
	"fmt"
	"strconv"
)

func integerOverflowNoncompliant() {
	value, err := strconv.Atoi("-2147483649")
	if err != nil {
		panic(err)
	}
	// Noncompliant: `int32` used with big value.
	newValue := int32(value)
	fmt.Println(newValue)
}
// {/fact}
