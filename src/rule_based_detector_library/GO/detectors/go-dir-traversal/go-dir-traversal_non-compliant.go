/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package go_dir_traversal

// {fact rule=go-dir-traversal@v1.0 defects=1}
import (
	net "net/http"
)

func dirTraversalNoncompliant() {
	// Noncompliant: Mounting the root directory `/` with `http.Dir`.
	d := net.Dir("/")
	f, err := d.Open("some file")
	if err != nil {
		panic(err)
	}
	defer f.Close()
}
// {/fact}
