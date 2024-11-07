// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package go_eqeq_is_bad

// {fact rule=go-eqeq-is-bad@v1.0 defects=0}
import "fmt"

func eqeqIsBadCompliant() {
	var s = "hello World!"
	// Compliant: Redundant comparison operation is not used.
	fmt.Println(s)
}
// {/fact}
