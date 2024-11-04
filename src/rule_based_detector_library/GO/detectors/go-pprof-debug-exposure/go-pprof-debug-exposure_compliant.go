/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package pprof_debug

// {fact rule=go-pprof-debug-exposure@v1.0 defects=0}
import (
	"fmt"
	"log"
	"net/http"
)

func pprofDebugExposureCompliant() {
	http.HandleFunc("/healthz", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Ok")
	})

	certFile := "YOUR_CERT_FILE"
	keyFile := "YOUR_KEY_FILE"
	serveMux := http.NewServeMux()

	// Compliant: `pprof` is disabled to prevent exposing sensitive data.
	log.Fatal(http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, serveMux))
}
// {/fact}
