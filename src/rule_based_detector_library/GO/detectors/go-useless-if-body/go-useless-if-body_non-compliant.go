/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package if_body

// {fact rule=go-useless-if-body@v1.0 defects=1}
import "fmt"

func uselessIfBodyNoncompliant(num int) {
	// Noncompliant: Both `if` and `else` have the same body.
	if num == 3 {
		fmt.Println("Hello")
	} else {
		fmt.Println("Hello")
	}
}
// {/fact}
