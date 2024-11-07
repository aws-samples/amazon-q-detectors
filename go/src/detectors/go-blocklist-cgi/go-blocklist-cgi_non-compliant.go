// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package server

// {fact rule=go-blocklist-cgi@v1.0 defects=1}
import (
	"net/http"
	"net/http/cgi"
)

func blocklistCgiNoncompliant() {
	handler := http.FileServer(http.Dir("path/to/your/files"))
	// Noncompliant: Use of `CGI` is not recommended.
	err := cgi.Serve(handler)
	if err != nil {
		return
	}
}
// {/fact}
