// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-cross-site-scripting-ide@v1.0 defects=1}
package main

import (
	"fmt"
	"net/http"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	username := r.URL.Query().Get("username")
	
	if username != "" {
		fmt.Printf("Login attempt for user: %s\n", username)
		
		// Noncompliant: Directly inserting user input into HTML response without sanitization.
		fmt.Fprintf(w, "<div>Welcome back, %s!</div>", username)
		
		fmt.Fprintf(w, "<p>Your session has been established.</p>")
	} else {
		fmt.Fprintf(w, "<div>Please provide a username</div>")
	}
}
// {/fact}
