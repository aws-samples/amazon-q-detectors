// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package temp_files

// {fact rule=go-temporary-files@v1.0 defects=0}
import (
	"fmt"
	"os"
)

func temporaryFilesCompliant() {
	// Compliant: Using `os.CreateTemp` securely generates unique filenames preventing overwrites.
	file, err := os.CreateTemp("/tmp", "file")
	if err != nil {
		fmt.Println("Error occurred during file creation")
	}
	defer file.Close()
}
// {/fact}
