// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package tainted_url_host

// {fact rule=go-tainted-url-host@v1.0 defects=0}
import (
	"net/http"
)

func taintedUrlHostCompliant(w http.ResponseWriter, r *http.Request) {
	urls, ok := r.URL.Query()["url"]
	if !ok || len(urls) == 0 {
		http.Error(w, "Missing url parameter", http.StatusBadRequest)
		return
	}
	url := "https://website.com"
	client := &http.Client{}

	// Compliant: The host part of the URL is not tainted.
	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	resp, err := client.Do(req)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
	defer resp.Body.Close()
}
// {/fact}
