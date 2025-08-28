// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-path-traversal@v1.0 defects=0}
package main

import (
	"net/http"
	"path"
	"strings"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	requestedFile := r.URL.Path[len("/files/"):]
	
	if !isValidFilePath(requestedFile) {
		http.Error(w, "Invalid file path", http.StatusBadRequest)
		return
	}
	
	// Compliant: Input validation prevents path traversal attacks.
	filePath := path.Join("files", requestedFile)
	http.ServeFile(w, r, filePath)
}

func isValidFilePath(filePath string) bool {
	return !path.IsAbs(filePath) && !strings.HasPrefix(filePath, "..")
}
// {/fact}
