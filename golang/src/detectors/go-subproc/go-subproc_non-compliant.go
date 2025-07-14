// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-subproc@v1.0 defects=1}
package main

import (
	"net/http"
	"os/exec"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	command := r.URL.Query().Get("cmd")

	// Noncompliant: User input used as executable name enables command injection.
	cmd := exec.Command(command, "arg1", "arg2")
	output, err := cmd.Output()
	if err != nil {
		http.Error(w, "Command failed", http.StatusInternalServerError)
		return
	}

	w.Write(output)
}
// {/fact}
