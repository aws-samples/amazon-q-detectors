// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package weak_rand

// {fact rule=go-weak-rand-source@v1.0 defects=1}
import (
	mrand "math/rand"
	"time"
)

var charset1 = []byte("abcdeABCDE0123456789")

func weakRandomNumberGenerationNoncompliant(length int) string {
	r := mrand.New(mrand.NewSource(time.Now().UnixNano()))
	result := make([]byte, length)
	for i := range result {
		// Noncompliant: `math.rand` is used for generating random number.
		result[i] = charset1[r.Intn(len(charset))]
	}
	return string(result)
}
// {/fact}
