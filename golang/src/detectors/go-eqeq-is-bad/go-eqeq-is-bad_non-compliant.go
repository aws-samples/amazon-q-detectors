// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package go_eqeq_is_bad

// {fact rule=go-eqeq-is-bad@v1.0 defects=1}
import "fmt"

func eqeqIsBadNoncompliant() {
	var s = "hello World!"
	// Noncompliant: Redundant comparison operation is used.
	if s == s {
		fmt.Println(s)
	}
}
// {/fact}
