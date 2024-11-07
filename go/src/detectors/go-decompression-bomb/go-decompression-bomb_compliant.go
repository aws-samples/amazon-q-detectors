// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package go_decompression_bomb

// {fact rule=go-decompression-bomb@v1.0 defects=0}
import (
	"bytes"
	"compress/zlib"
	"fmt"
	"io"
	"os"
)

func decompressionBombCompliant() {
	b := []byte{120, 156, 202, 72, 205, 201, 201, 215, 81, 40, 207,
		47, 202, 73, 225, 2, 4, 0, 0, 255, 255, 33, 231, 4, 147}
	bb := bytes.NewReader(b)
	r, err := zlib.NewReader(bb)
	if err != nil {
		panic(err)
	}
	// Compliant: Limiting the max bytes read using `io.LimitReader()`.
	res := io.LimitReader(r, 8)
	out, err := io.Copy(os.Stdout, res)
	if err != nil {
		panic(err)
	}
	fmt.Printf("out: %v", out)
}
// {/fact}
