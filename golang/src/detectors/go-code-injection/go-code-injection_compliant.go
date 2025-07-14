// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-code-injection@v1.0 defects=0}
package main

import (
	"net/http"
	"os/exec"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	action := r.URL.Query().Get("action")
	
	// Compliant: Allowlist validation prevents code injection.
	validActions := map[string]bool{"status": true, "uptime": true, "date": true}
	if !validActions[action] {
		return
	}
	
	cmd := exec.Command(action)
	cmd.Output()
}
// {/fact}
