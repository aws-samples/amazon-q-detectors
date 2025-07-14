// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-file-read-taint@v1.0 defects=0}
package main

import (
	"io/ioutil"
	"net/http"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	// Compliant: Hardcoded file path prevents path traversal attacks.
	data, err := ioutil.ReadFile("./config/settings.json")
	if err != nil {
		http.Error(w, "File not found", http.StatusNotFound)
		return
	}

	w.Write(data)
}
// {/fact}
