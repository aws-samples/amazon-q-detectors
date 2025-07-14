// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-weak-crypto@v1.0 defects=1}
package main

import (
	"crypto/md5"
	"io"
	"net/http"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	password := r.FormValue("password")

	// Noncompliant: `MD5` is cryptographically weak and vulnerable to collisions.
	h := md5.New()
	io.WriteString(h, password)
	passwordHash := h.Sum(nil)
	
	setPassword(passwordHash)
}

func setPassword(hash []byte) {
}
// {/fact}
