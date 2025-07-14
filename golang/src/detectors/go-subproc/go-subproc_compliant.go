// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-subproc@v1.0 defects=0}
package main

import (
	"net/http"
	"os/exec"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	// Compliant: Hardcoded command prevents command injection attacks.
	cmd := exec.Command("cat", "/var/log/app.log")
	output, err := cmd.Output()
	if err != nil {
		http.Error(w, "Command failed", http.StatusInternalServerError)
		return
	}

	w.Write(output)
}
// {/fact}
