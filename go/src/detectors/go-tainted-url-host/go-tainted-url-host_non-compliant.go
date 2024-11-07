// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package tainted_url_host

// {fact rule=go-tainted-url-host@v1.0 defects=1}
import (
	"fmt"
	"net/http"
)

func taintedUrlHostNoncompliant(w http.ResponseWriter, r *http.Request) {
	urls, ok := r.URL.Query()["url"]
	if !ok || len(urls) == 0 {
		http.Error(w, "Missing url parameter", http.StatusBadRequest)
		return
	}
	url := fmt.Sprintf("//%s/path/to/folder", urls[0])
	client := &http.Client{}

	// Noncompliant: The host part of the URL is tainted.
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
