/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package httputil

// {fact rule=go-http-listenandservetls@v1.0 defects=0}
import (
	"net/http"
)

func httpListenandservetlsCompliant(certFile string, keyFile string) {
	handler := func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "text/plain")
		w.Write([]byte("Hello!"))
	}
	http.HandleFunc("/test", handler)
	// Compliant: `http.ListenAndServeTLS` is used (with certificate and key).
	if err := http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, nil); err != nil {
		panic(err)
	}
}
// {/fact}
