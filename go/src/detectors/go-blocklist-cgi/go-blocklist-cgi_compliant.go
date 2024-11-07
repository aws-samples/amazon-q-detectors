// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package server

// {fact rule=go-blocklist-cgi@v1.0 defects=0}
import "net/http"

func blocklistCgiCompliant() http.Handler {
	filesDir := "path/to/your/files"
	// Compliant: Using `http.FileServer` directly without involving `CGI`.
	return http.StripPrefix("/files/", http.FileServer(http.Dir(filesDir)))
}
// {/fact}
