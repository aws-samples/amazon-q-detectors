// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package xssprotection

// {fact rule=go-wrong-response-writer-usage@v1.0 defects=0}
import (
	"fmt"
	"html"
	"html/template"
	"net/http"
	"regexp"
)

func wrongResponseWriterUsageCompliant(w http.ResponseWriter, r *http.Request) {
	userTitle := r.URL.Query().Get("title")

	validTitle := regexp.MustCompile(`^[a-zA-Z0-9 .,!?-]+$`)
	if !validTitle.MatchString(userTitle) {
		http.Error(w, "Invalid title", http.StatusBadRequest)
		return
	}

	safeTitle := html.EscapeString(userTitle)
	
	// Compliant: Validates and sanitizes user input before rendering it safely using `html/template`.
	tmpl := template.Must(template.New("page").Parse("<html><body><h1>{{.}}</h1><p>This is the content</p></body></html>"))
	
	w.Header().Set("Content-Type", "text/html; charset=utf-8")
	w.WriteHeader(http.StatusAccepted)
	tmpl.Execute(w, safeTitle)
}
// {/fact}
