// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-cross-site-scripting-ide@v1.0 defects=0}
package main

import (
	"fmt"
	"html"
	"net/http"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	username := r.URL.Query().Get("username")
	
	if username != "" {
		fmt.Printf("Login attempt for user: %s\n", username)
		
		// Compliant: Properly sanitizing user input before inserting into HTML response.
		safeUsername := html.EscapeString(username)
		fmt.Fprintf(w, "<div>Welcome back, %s!</div>", safeUsername)
		
		fmt.Fprintf(w, "<p>Your session has been established.</p>")
	} else {
		fmt.Fprintf(w, "<div>Please provide a username</div>")
	}
}
// {/fact}
