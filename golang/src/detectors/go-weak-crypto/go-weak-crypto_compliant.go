// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-weak-crypto@v1.0 defects=0}
package main

import (
	"crypto/sha256"
	"io"
	"net/http"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	password := r.FormValue("password")

	// Compliant: `SHA-256` is cryptographically strong and resistant to collisions.
	h := sha256.New()
	io.WriteString(h, password)
	passwordHash := h.Sum(nil)
	
	setPassword(passwordHash)
}

func setPassword(hash []byte) {
}
// {/fact}
