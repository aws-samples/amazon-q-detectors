// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package hidden_goroutine

// {fact rule=go-hidden-goroutine@v1.0 defects=0}
import (
	"fmt"
)

func hiddenGoroutineCompliant() {
	// Compliant: There are other operations along with the goroutine.
	if num := 17; num < 0 {
		fmt.Println(num, "is negative")
	}
	go func() {
		if 5 % 2 == 0 {
			fmt.Println("5 is even")
		} else {
			fmt.Println("5 is odd")
		}
	}()
	if 8 % 2 == 0 {
		fmt.Println("8 is even")
	}
}
// {/fact}
