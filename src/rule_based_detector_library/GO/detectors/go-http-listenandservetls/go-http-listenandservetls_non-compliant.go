/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package httputil

// {fact rule=go-http-listenandservetls@v1.0 defects=1}
import (
	"net/http"
)

func httpListenandservetlsNoncompliant() {
	handler := func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "text/plain")
		w.Write([]byte("Hello!"))
	}
	http.HandleFunc("/test", handler)
	// Noncompliant: `http.ListenAndServe` is used (without certificate and key).
	if err := http.ListenAndServe("192.168.1.101:2000", nil); err != nil {
		panic(err)
	}
}
// {/fact}
