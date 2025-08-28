// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-log-injection-ide@v1.0 defects=1}
package main

import (
	"log"
	"net/http"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	username := r.URL.Query().Get("user")

	// Noncompliant: User input directly in log message enables log injection.
	log.Printf("User login attempt: %s", username)

	w.Write([]byte("Login processed"))
}
// {/fact}
