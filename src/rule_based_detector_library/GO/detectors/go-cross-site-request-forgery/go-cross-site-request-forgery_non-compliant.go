// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package csrf

// {fact rule=go-cross-site-request-forgery@v1.0 defects=1}
import (
	"fmt"
	"html"
	"net/http"
)

func crossSiteRequestForgeryNoncompliant(w http.ResponseWriter, r *http.Request) {
	// Noncompliant: Does not validate the CSRF token before processing the request.
	fmt.Fprintf(w, "Go to: %s", html.EscapeString(r.URL.Path))
}
// {/fact}
