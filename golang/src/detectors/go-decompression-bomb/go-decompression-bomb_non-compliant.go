// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-decompression-bomb@v1.0 defects=1}
package main

import (
	"bytes"
	"compress/zlib"
	"io"
	"os"
)

func noncompliant() {
	b := []byte{120, 156, 202, 72, 205, 201, 201, 215, 81, 40, 207,
		47, 202, 73, 225, 2, 4, 0, 0, 255, 255, 33, 231, 4, 147}
	bb := bytes.NewReader(b)
	r, _ := zlib.NewReader(bb)
	
	// Noncompliant: Unlimited decompression enables decompression bomb attacks.
	io.Copy(os.Stdout, r)
}
// {/fact}
