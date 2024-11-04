/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package nil_pointer

// {fact rule=go-nil-pointer-dereference@v1.0 defects=0}
import "fmt"

func nilPointerDereferenceCompliant(ptr *int) {
	if ptr != nil {
		// Compliant: Nil check before accessing memory address.
		fmt.Println(*ptr)
	} else {
		fmt.Println("Pointer is nil")
	}
}
// {/fact}
