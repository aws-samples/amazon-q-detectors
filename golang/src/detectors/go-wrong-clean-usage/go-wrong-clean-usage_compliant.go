// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-wrong-clean-usage@v1.0 defects=0}
package main

import (
	"io/ioutil"
	"net/http"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	// Compliant: Using hardcoded path prevents path traversal attacks.
	data, err := ioutil.ReadFile("/safe/config.txt")
	if err != nil {
		http.Error(w, "File not found", http.StatusNotFound)
		return
	}

	w.Write(data)
}
// {/fact}
