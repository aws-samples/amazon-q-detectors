// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-jwt-parse-unverified@v1.0 defects=1}
package main

import (
	"fmt"
	"github.com/dgrijalva/jwt-go"
	"net/http"
	"strings"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	authHeader := r.Header.Get("Authorization")
	if authHeader == "" {
		http.Error(w, "Authorization header required", http.StatusUnauthorized)
		return
	}

	tokenString := strings.Replace(authHeader, "Bearer ", "", 1)

	// Noncompliant: Using `ParseUnverified()` skips signature validation allowing token forgery.
	token, _, err := new(jwt.Parser).ParseUnverified(tokenString, jwt.MapClaims{})
	if err != nil {
		http.Error(w, "Invalid token", http.StatusUnauthorized)
		return
	}

	if claims, ok := token.Claims.(jwt.MapClaims); ok {
		username := claims["username"]
		role := claims["role"]
		fmt.Fprintf(w, "Welcome %v with role %v", username, role)
	} else {
		http.Error(w, "Invalid claims", http.StatusUnauthorized)
	}
}
// {/fact}
