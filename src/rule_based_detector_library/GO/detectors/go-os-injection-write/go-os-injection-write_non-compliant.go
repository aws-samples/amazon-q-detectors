// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package os_injection

// {fact rule=go-os-injection-write@v1.0 defects=1}
import (
	"fmt"
	"net/http"
	"os/exec"
)

func osInjectionWriteNoncompliant(w http.ResponseWriter, r *http.Request) {
	input := r.URL.Query().Get("input")

	cmd := exec.Command("bash")
	cmdStdin, err := cmd.StdinPipe()
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	cmd.Start()
	customCommand := fmt.Sprintf("echo %s\n", input)
	// Noncompliant: Unsanitized user input is passed to `Write`.
	if _, err := cmdStdin.Write([]byte(customCommand)); err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
	cmd.Wait()

	fmt.Fprintln(w, "Command executed")
}
// {/fact}
