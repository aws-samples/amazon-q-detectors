// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package httputil

// {fact rule=go-httptrace-fileserver-as-handler@v1.0 defects=0}
import (
	"log"
	"net/http"
)

func httpTraceFileServerAsHandlerCompliant() {
	// Compliant: `http.FileServer` is not used.
	p := func(w http.ResponseWriter, _ *http.Request) {
		w.Write([]byte("<p>Hello!!!</p>"))
	}
	certFile := "YOUR_CERT_FILE"
	keyFile := "YOUR_KEY_FILE"
	mux := http.NewServeMux()
	mux.HandleFunc("/", p)
	log.Fatal(http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, mux))
}
// {/fact}
