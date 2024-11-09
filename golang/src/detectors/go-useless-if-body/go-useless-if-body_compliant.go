// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package if_body

// {fact rule=go-useless-if-body@v1.0 defects=0}
import "fmt"

func uselessIfBodyCompliant(num int) {
	// Compliant: `if` and `else` have different bodies.
	if num == 3 {
		fmt.Println("Hello")
	} else {
		fmt.Println("Bye")
	}
}
// {/fact}
