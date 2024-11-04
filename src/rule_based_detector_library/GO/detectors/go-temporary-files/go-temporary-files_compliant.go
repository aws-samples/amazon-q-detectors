/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package temp_files

// {fact rule=go-temporary-files@v1.0 defects=0}
import (
	"fmt"
	"os"
)

func temporaryFilesCompliant() {
	// Compliant: File creation in shared tmp directory using `os.CreateTemp`,
	// which securely generates a unique filename, preventing overwriting or collision.
	file, err := os.CreateTemp("/tmp", "file")
	if err != nil {
		fmt.Println("Error occurred during file creation")
	}
	defer file.Close()
}
// {/fact}
