/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package temp_files

// {fact rule=go-temporary-files@v1.0 defects=1}
import (
	"fmt"
	"os"
)

func temporaryFilesNoncompliant() {
	// Noncompliant: File creation in shared tmp directory without using `os.CreateTemp`,
	// which might lead to security vulnerabilities, such as file overwrites.
	file, err := os.Create("/tmp/file")
	if err != nil {
		fmt.Println("Error occurred during file creation")
	}
	defer file.Close()
}
// {/fact}
