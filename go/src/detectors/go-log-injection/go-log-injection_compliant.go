// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package log_injection

// {fact rule=go-log-injection@v1.0 defects=0}
import (
	"log"
	"net/http"
	"strings"
)

func logInjectionCompliant(req *http.Request) {
	username := req.URL.Query()["username"][0]
	escapedUsername := strings.ReplaceAll(username, "\n", "")
	escapedUsername = strings.ReplaceAll(escapedUsername, "\r", "")
	// Compliant: User provided input is sanitized before passing to log.
	log.Printf("user %s logged in.\n", escapedUsername)
}
// {/fact}
