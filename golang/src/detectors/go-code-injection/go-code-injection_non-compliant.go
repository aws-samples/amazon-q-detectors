// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-code-injection@v1.0 defects=1}
package main

import (
	"net/http"
	"os/exec"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	command := r.URL.Query().Get("cmd")
	
	// Noncompliant: User input directly in system command enables code injection.
	cmd := exec.Command("sh", "-c", command)
	cmd.Output()
}
// {/fact}
