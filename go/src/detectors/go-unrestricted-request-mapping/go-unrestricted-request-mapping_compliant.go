// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package request_mapping

// {fact rule=go-unrestricted-request-mapping@v1.0 defects=0}
import (
	"github.com/gorilla/mux"
	"net/http"
)

func unrestrictedRequestMappingCompliant() {
	handler := func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "text/plain")
		w.Write([]byte("Hello!"))
	}
	router := mux.NewRouter()
	// Compliant: HTTP request methods are restricted.
	router.HandleFunc("/allowed-path1", handler).Methods("GET")
	http.Handle("/", router)
}
// {/fact}
