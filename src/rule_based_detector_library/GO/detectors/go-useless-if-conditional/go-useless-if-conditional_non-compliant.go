/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package if_condition

// {fact rule=go-useless-if-conditional@v1.0 defects=1}
import "fmt"

func uselessIfConditionNoncompliant(num int) {
	// Noncompliant: Both `if` conditions are the same.
	if num == 3 {
		fmt.Println("Hello")
	} else if num == 3 {
		fmt.Println("Bye")
	}
}
// {/fact}
