// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-decompression-bomb@v1.0 defects=0}
package main

import (
	"bytes"
	"compress/zlib"
	"io"
	"os"
)

func compliant() {
	b := []byte{120, 156, 202, 72, 205, 201, 201, 215, 81, 40, 207,
		47, 202, 73, 225, 2, 4, 0, 0, 255, 255, 33, 231, 4, 147}
	bb := bytes.NewReader(b)
	r, _ := zlib.NewReader(bb)
	
	// Compliant: `io.LimitReader()` prevents decompression bomb attacks.
	limitedReader := io.LimitReader(r, 8)
	io.Copy(os.Stdout, limitedReader)
}
// {/fact}
