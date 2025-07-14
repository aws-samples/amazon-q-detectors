// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-unsafe-deserialization@v1.0 defects=1}
package main

import (
	"encoding/gob"
	"net/http"
	"strings"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	userInput := r.URL.Query().Get("data")
	var decodedData interface{}

	// Noncompliant: Deserializing untrusted user input enables code execution.
	gob.NewDecoder(strings.NewReader(userInput)).Decode(&decodedData)

	w.Write([]byte("Data processed"))
}
// {/fact}
