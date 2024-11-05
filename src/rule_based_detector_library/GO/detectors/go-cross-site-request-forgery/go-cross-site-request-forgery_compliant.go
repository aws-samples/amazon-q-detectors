// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package csrf

// {fact rule=go-cross-site-request-forgery@v1.0 defects=0}
import (
	"fmt"
	"html"
	"net/http"
)

func crossSiteRequestForgeryCompliant(w http.ResponseWriter, r *http.Request, csrfToken string) {
	csrfTokenFromForm := r.FormValue("csrf_token")
	if csrfTokenFromForm != csrfToken {
		http.Error(w, "Invalid CSRF token", http.StatusForbidden)
		return
	}

	// Compliant: Validates the CSRF token before processing the request.
	fmt.Fprintf(w, "Go to: %s", html.EscapeString(r.URL.Path))
}
// {/fact}
