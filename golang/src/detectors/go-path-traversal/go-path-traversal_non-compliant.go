// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-path-traversal@v1.0 defects=1}
package main

import (
	"net/http"
	"path"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	filePath := "./files/" + r.URL.Path[len("/files/"):]
	
	// Noncompliant: Unsanitized user input in file path enables path traversal.
	filePath = path.Join("files", filePath)
	http.ServeFile(w, r, filePath)
}
// {/fact}
