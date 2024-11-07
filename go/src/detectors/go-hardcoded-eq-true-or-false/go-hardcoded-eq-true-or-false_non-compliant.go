// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package eq

// {fact rule=go-hardcoded-eq-true-or-false@v1.0 defects=1}
import "fmt"

func hardcodedEqTrueOrFalseNoncompliant(num int) {
	// Noncompliant: `if` statement with hardcoded `true` condition.
	if num == 5 && true {
		fmt.Println("Hello")
	}
}
// {/fact}
