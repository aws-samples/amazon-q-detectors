// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package os_injection

// {fact rule=go-os-injection-write@v1.0 defects=0}
import (
	"fmt"
	"net/http"
	"os/exec"
)

func osInjectionWriteCompliant(w http.ResponseWriter, r *http.Request) error {
	cmd := exec.Command("bash")
	cmdStdin, err := cmd.StdinPipe()
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return err
	}

	// Compliant: Hardcoded value is passed to `Write`.
	if _, err := cmdStdin.Write([]byte("echo Hello")); err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return err
	}
	cmd.Wait()

	fmt.Fprintln(w, "Command executed")
	return nil
}
// {/fact}
