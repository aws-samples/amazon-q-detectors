// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-wrong-clean-usage@v1.0 defects=1}
package main

import (
	"io/ioutil"
	"net/http"
	"path/filepath"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	userPath := r.URL.Query().Get("path")

	// Noncompliant: Using `filepath.Clean` alone doesn't prevent path traversal attacks.
	cleanPath := filepath.Clean(userPath)
	data, err := ioutil.ReadFile(cleanPath)
	if err != nil {
		http.Error(w, "File not found", http.StatusNotFound)
		return
	}

	w.Write(data)
}
// {/fact}
