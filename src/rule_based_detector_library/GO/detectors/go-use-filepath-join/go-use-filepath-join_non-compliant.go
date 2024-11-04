/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package file_path_join

// {fact rule=go-use-filepath-join@v1.0 defects=1}
import (
	"fmt"
	"path"
)

func useFilepathJoinNoncompliant() {
	pathname := "YOUR_PATH"
	// Noncompliant: Uses `path.Join()` instead of `filepath.Join()`.
	fmt.Println(path.Join(path.Base(pathname), "baz"))
}
// {/fact}
