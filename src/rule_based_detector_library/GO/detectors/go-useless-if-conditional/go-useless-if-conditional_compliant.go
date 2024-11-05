// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package if_condition

// {fact rule=go-useless-if-conditional@v1.0 defects=0}
import "fmt"

func uselessIfConditionCompliant(num int) {
	// Compliant: No unnecessary `if` condition.
	if num == 3 {
		fmt.Println("Hello")
	}
}
// {/fact}
