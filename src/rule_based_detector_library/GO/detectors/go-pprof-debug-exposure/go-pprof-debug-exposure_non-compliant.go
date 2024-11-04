/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package pprof_debug

// {fact rule=go-pprof-debug-exposure@v1.0 defects=1}
import (
	"fmt"
	"log"
	"net/http"
	_ "net/http/pprof"
)

func pprofDebugExposureNoncompliant() {
	http.HandleFunc("/healthz", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Not Ok")
	})

	certFile := "YOUR_CERT_FILE"
	keyFile := "YOUR_KEY_FILE"

	// Noncompliant: `pprof` is enabled and can expose sensitive data.
	log.Fatal(http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, nil))
}
// {/fact}
