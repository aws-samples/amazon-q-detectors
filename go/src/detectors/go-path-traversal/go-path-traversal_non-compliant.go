// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package path_traversal

// {fact rule=go-path-traversal@v1.0 defects=1}
import (
	"net/http"
	"path"
)

func pathTraversalNoncompliant(certFile string, keyFile string) {
	http.HandleFunc("/files/", func(w http.ResponseWriter, r *http.Request) {
		filePath := "./files/" + r.URL.Path[len("/files/"):]
		// Noncompliant: Unsanitized input is passed to `path.Join()`.
		filePath = path.Join("files", filePath)
		http.ServeFile(w, r, filePath)
	})

	http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, nil)
}
// {/fact}
