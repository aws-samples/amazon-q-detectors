// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-subproc@v1.0 defects=0}
package main

import (
	"net/http"
	"os/exec"
	"regexp"
)

func compliant(w http.ResponseWriter, r *http.Request) {

	userInput := r.URL.Query().Get("filename")
	
	re := regexp.MustCompile(`^[a-zA-Z0-9_\-\.]+$`)
	if !re.MatchString(userInput) {
		http.Error(w, "Invalid input", http.StatusBadRequest)
		return
	}
	
	// Compliant: Use a hardcoded command with sanitized input.
	cmd := exec.Command("cat", "/var/log/"+userInput)
	output, err := cmd.Output()
	if err != nil {
		http.Error(w, "Command failed", http.StatusInternalServerError)
		return
	}

	w.Write(output)
}
// {/fact}
