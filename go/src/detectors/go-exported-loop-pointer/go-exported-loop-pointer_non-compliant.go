// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package go_exported_loop_pointer

// {fact rule=go-exported-loop-pointer@v1.0 defects=1}
import (
	"fmt"
)

func exportedLoopPointerNoncompliant() {
	names := []string{"Jack", "Tom", "Sam", "Mark", "John"}
	var fs []func()
	for _, name := range names {
		fs = append(fs, func() {
			// Noncompliant: Loop pointer reference is shared across iterations.
			fmt.Println(&name)
		})
	}
}
// {/fact}
