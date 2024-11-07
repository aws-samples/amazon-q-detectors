// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package go_exported_loop_pointer

// {fact rule=go-exported-loop-pointer@v1.0 defects=0}
import (
	"fmt"
)

func exportedLoopPointerCompliant() {
	names := []string{"Jack", "Tom", "Sam", "Mark", "John"}
	var fs []func()
	for _, name := range names {
		// Compliant: Variable `name` is copied to a new variable within the loop before exporting.
		name := name
		fs = append(fs, func() {
			fmt.Println(&name)
		})
	}
}
// {/fact}
