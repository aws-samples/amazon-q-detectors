// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-dir-traversal@v1.0 defects=1}
package main

import (
	"net/http"
)

func noncompliant() {
	// Noncompliant: Mounting root directory exposes entire filesystem to path traversal attacks.
	fileServer := http.FileServer(http.Dir("/"))
	
	http.Handle("/files/", http.StripPrefix("/files/", fileServer))
	http.ListenAndServe(":8080", nil)
}
// {/fact}
