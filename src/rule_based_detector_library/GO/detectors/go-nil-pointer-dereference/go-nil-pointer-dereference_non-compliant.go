/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package nil_pointer

// {fact rule=go-nil-pointer-dereference@v1.0 defects=1}
import "fmt"

func nilPointerDereferenceNoncompliant(ptr *int) {
	// Noncompliant: Accessing memory address that is not initialized.
	fmt.Println(*ptr)
}
// {/fact}
