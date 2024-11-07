// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package math_big_rat

// {fact rule=go-math-big-rat@v1.0 defects=1}
import (
	"fmt"
	"math/big"
)

func mathBigRatNoncompliant() {
	s := "2147483648"
	r := big.Rat{}
	// Noncompliant: Lack of validation may lead to integer overflow.
	r.SetString(s)
	num, _ := r.Float32()
	fmt.Println(num)
}
// {/fact}
