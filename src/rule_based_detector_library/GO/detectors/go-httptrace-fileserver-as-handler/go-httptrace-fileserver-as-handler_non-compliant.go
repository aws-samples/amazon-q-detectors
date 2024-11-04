/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package httputil

// {fact rule=go-httptrace-fileserver-as-handler@v1.0 defects=1}
import (
	"log"
	"net/http"
)

func httpTraceFileServerAsHandlerNoncompliant() {
	certFile := "YOUR_CERT_FILE"
	keyFile := "YOUR_KEY_FILE"
	// Noncompliant: `http.FileServer` is used.
	fs := http.FileServer(http.Dir("/dir"))
	log.Fatal(http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, fs))
}
// {/fact}
