// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-ssrf@v1.0 defects=0}
package main

import (
	"fmt"
	"net/http"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	// Compliant: Hardcoded URL prevents SSRF attacks.
	resp, err := http.Get("https://api.example.com/data")
	if err != nil {
		http.Error(w, "Request failed", http.StatusInternalServerError)
		return
	}
	defer resp.Body.Close()

	fmt.Fprintf(w, "Response status: %d", resp.StatusCode)
}
// {/fact}
