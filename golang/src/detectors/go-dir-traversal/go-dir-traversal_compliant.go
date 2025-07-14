// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-dir-traversal@v1.0 defects=0}
package main

import (
	"net/http"
)

func compliant() {
	// Compliant: Restricting access to specific directory prevents path traversal attacks.
	fileServer := http.FileServer(http.Dir("./public"))
	
	http.Handle("/files/", http.StripPrefix("/files/", fileServer))
	http.ListenAndServe(":8080", nil)
}
// {/fact}
