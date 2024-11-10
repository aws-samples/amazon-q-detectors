// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package file_path_join

// {fact rule=go-use-filepath-join@v1.0 defects=0}
import (
	"fmt"
	"path"
	"path/filepath"
)

func useFilepathJoinCompliant() {
	pathname := "YOUR_PATH"
	// Compliant: Uses `filepath.Join()`.
	fmt.Println(filepath.Join(path.Base(pathname), "baz"))
}
// {/fact}
