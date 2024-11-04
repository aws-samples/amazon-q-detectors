/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package code_injection

// {fact rule=go-code-injection@v1.0 defects=1}
import (
	"net/http"
	"os"
	"os/exec"
)

func CodeInjectionNoncompliant(w http.ResponseWriter, r *http.Request) {
	cmdPath := r.URL.Query().Get("cmd")

	// Noncompliant: Unsanitized input is used as part of the command execution.
	cmd := &exec.Cmd{
		Path:   cmdPath,
		Args:   []string{"test", "sample"},
		Stdout: os.Stdout,
		Stderr: os.Stdout,
	}

	err := cmd.Start()
	if err != nil {
		return
	}
}
// {/fact}
