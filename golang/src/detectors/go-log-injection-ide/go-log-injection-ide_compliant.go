// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-log-injection-ide@v1.0 defects=0}
package main

import (
	"log"
	"net/http"
	"strings"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	username := r.URL.Query().Get("user")

	sanitizedUsername := sanitizeForLogging(username)

	// Compliant: Sanitized input prevents log injection attacks.
	log.Printf("User login attempt: %s", sanitizedUsername)

	w.Write([]byte("Login processed"))
}

func sanitizeForLogging(input string) string {
	sanitized := strings.ReplaceAll(input, "\n", "")
	sanitized = strings.ReplaceAll(sanitized, "\r", "")
	return sanitized
}
// {/fact}
