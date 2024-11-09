// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package request_mapping

// {fact rule=go-unrestricted-request-mapping@v1.0 defects=1}
import (
	"github.com/gorilla/mux"
	"net/http"
)

func unrestrictedRequestMappingNoncompliant() {
	handler := func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "text/plain")
		w.Write([]byte("Hello!"))
	}
	router := mux.NewRouter()
	// Noncompliant: HTTP request methods are not restricted.
	router.PathPrefix("/unrestricted").HandlerFunc(handler)
	http.Handle("/", router)
}
// {/fact}
