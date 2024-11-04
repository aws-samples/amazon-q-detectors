/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package path_traversal

// {fact rule=go-path-traversal@v1.0 defects=0}
import (
	"net/http"
	"path"
	"strings"
)

func pathTraversalCompliant(certFile string, keyFile string) {
	http.HandleFunc("/files/", func(w http.ResponseWriter, r *http.Request) {
		requestedFile := r.URL.Path[len("/files/"):]
		if !isValidFilePath(requestedFile) {
			http.Error(w, "Invalid file path", http.StatusBadRequest)
			return
		}
		// Compliant: Input is validated before passing to `path.Join()`
		filePath := path.Join("files", requestedFile)
		http.ServeFile(w, r, filePath)
	})

	http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, nil)
}

func isValidFilePath(filePath string) bool {
	return !path.IsAbs(filePath) && !strings.HasPrefix(filePath, "..")
}
// {/fact}
