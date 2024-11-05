// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package xssprotection

// {fact rule=go-wrong-response-writer-usage@v1.0 defects=0}
import (
	"fmt"
	"html"
	"net/http"
)

func wrongResponseWriterUsageCompliant(w http.ResponseWriter, r *http.Request) {
	userTitle := r.URL.Query().Get("title")

	// Compliant: Sanitizes the user input before writing to the response.
	templateHTML := "<html><body><h1>%s</h1><p>This is the content</p></body></html>"
	w.WriteHeader(http.StatusAccepted)
	w.Write([]byte(fmt.Sprintf(templateHTML, html.EscapeString(userTitle))))
}
// {/fact}
