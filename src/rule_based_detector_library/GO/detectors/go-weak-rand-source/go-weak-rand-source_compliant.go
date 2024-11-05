// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package weak_rand

// {fact rule=go-weak-rand-source@v1.0 defects=0}
import (
	crand "crypto/rand"
	"math/big"
)

var charset = []byte("abcdeABCDE0123456789")

func weakRandomNumberGenerationCompliant(length int) string {
	result := make([]byte, length)
	max := big.NewInt(int64(len(charset)))
	for i := range result {
		// Compliant: `crypto/rand` is used for generating secure random number.
		n, _ := crand.Int(crand.Reader, max)
		result[i] = charset[n.Int64()]
	}
	return string(result)
}
// {/fact}
