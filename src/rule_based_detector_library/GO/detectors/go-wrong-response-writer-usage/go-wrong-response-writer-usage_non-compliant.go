/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package xssprotection

// {fact rule=go-wrong-response-writer-usage@v1.0 defects=1}
import (
	"fmt"
	"net/http"
)

func wrongResponseWriterUsageNoncompliant(w http.ResponseWriter, r *http.Request) {
	userTitle := r.URL.Query().Get("title")

	// Noncompliant: Writes unsanitized, user-provided input directly to the response.
	templateHTML := "<html><body><h1>%s</h1><p>This is the content</p></body></html>"
	w.WriteHeader(http.StatusAccepted)
	w.Write([]byte(fmt.Sprintf(templateHTML, userTitle)))
}
// {/fact}
