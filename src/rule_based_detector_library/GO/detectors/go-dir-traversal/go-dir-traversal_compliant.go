/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package go_dir_traversal

// {fact rule=go-dir-traversal@v1.0 defects=0}
import (
	net "net/http"
)

func dirTraversalCompliant() {
	// Compliant: Not mounting the root directory '/' with `http.Dir`.
	d := net.Dir("/dir/newdir")
	f, err := d.Open("some file")
	if err != nil {
		panic(err)
	}
	defer f.Close()
}
// {/fact}
