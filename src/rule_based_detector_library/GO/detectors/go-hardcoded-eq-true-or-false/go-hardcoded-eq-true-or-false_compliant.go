/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package eq

// {fact rule=go-hardcoded-eq-true-or-false@v1.0 defects=0}
import "fmt"

func hardcodedEqTrueOrFalseCompliant(num int) {
	// Compliant: `if` statement without hardcoded condition.
	if num == 5 {
		fmt.Println("Hello")
	}
}
// {/fact}
