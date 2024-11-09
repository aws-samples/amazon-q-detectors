// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package math_big_rat

// {fact rule=go-math-big-rat@v1.0 defects=0}
import (
	"fmt"
	"math/big"
	"strconv"
)

func mathBigRatCompliant() {
	s := "2147483648"
	r := big.Rat{}
	// Compliant: Validation for integer size before invoking `big.Rat.SetString`.
	_, err := strconv.ParseInt(s, 10, 32)
	if err != nil {
		panic(err)
	}
	r.SetString(s)
	num, _ := r.Float32()
	fmt.Println(num)
}
// {/fact}
