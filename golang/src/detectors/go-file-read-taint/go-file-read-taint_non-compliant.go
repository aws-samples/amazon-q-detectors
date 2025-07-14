// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-file-read-taint@v1.0 defects=1}
package main

import (
	"io/ioutil"
	"net/http"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	filename := r.URL.Query().Get("file")

	// Noncompliant: User input directly used in file operations enables path traversal.
	data, err := ioutil.ReadFile(filename)
	if err != nil {
		http.Error(w, "File not found", http.StatusNotFound)
		return
	}

	w.Write(data)
}
// {/fact}
