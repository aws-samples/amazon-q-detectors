// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-unsafe-deserialization@v1.0 defects=0}
package main

import (
	"encoding/json"
	"net/http"
)

type User struct {
	Name  string `json:"name"`
	Email string `json:"email"`
}

func compliant(w http.ResponseWriter, r *http.Request) {
	var user User

	// Compliant: Using JSON deserialization with validation prevents code execution.
	decoder := json.NewDecoder(r.Body)
	err := decoder.Decode(&user)
	if err != nil {
		http.Error(w, "Invalid JSON", http.StatusBadRequest)
		return
	}

	if len(user.Name) > 100 || len(user.Email) > 100 {
		http.Error(w, "Invalid input", http.StatusBadRequest)
		return
	}

	w.Write([]byte("User: " + user.Name))
}
// {/fact}
