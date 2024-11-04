/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package code_injection

// {fact rule=go-code-injection@v1.0 defects=0}
import (
	"os"
	"os/exec"
)

func codeInjectionCompliant() {
	// Compliant: Using a trusted source for the command path.
	cmdPath, _ := exec.LookPath("go")

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
