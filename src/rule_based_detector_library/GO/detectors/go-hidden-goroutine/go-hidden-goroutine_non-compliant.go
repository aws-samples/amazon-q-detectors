// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package hidden_goroutine

// {fact rule=go-hidden-goroutine@v1.0 defects=1}
import (
	"fmt"
)

func hiddenGoroutineNoncompliant() {
	// Noncompliant: Hidden goroutines inside functions.
	go func() {
		if 5 % 2 == 0 {
			fmt.Println("5 is even")
		} else {
			fmt.Println("5 is odd")
		}
	}()
}
// {/fact}
