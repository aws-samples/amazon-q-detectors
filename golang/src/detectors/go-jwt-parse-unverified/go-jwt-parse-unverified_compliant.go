// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-jwt-parse-unverified@v1.0 defects=0}
package main

import (
	"fmt"
	"github.com/dgrijalva/jwt-go"
	"net/http"
	"strings"
)

func compliant(w http.ResponseWriter, r *http.Request) {
	authHeader := r.Header.Get("Authorization")
	if authHeader == "" {
		http.Error(w, "Authorization header required", http.StatusUnauthorized)
		return
	}

	tokenString := strings.Replace(authHeader, "Bearer ", "", 1)

	keyFunc := func(token *jwt.Token) (interface{}, error) {
		if _, ok := token.Method.(*jwt.SigningMethodHMAC); !ok {
			return nil, fmt.Errorf("unexpected signing method: %v", token.Header["alg"])
		}
		
		// Compliant: Return the secret key for signature verification.
		return []byte("your-secret-key"), nil
	}

	// Compliant: Using `ParseWithClaims()` properly verifies the token signature.
	token, err := jwt.ParseWithClaims(tokenString, jwt.MapClaims{}, keyFunc)
	if err != nil {
		http.Error(w, "Invalid token", http.StatusUnauthorized)
		return
	}

	if claims, ok := token.Claims.(jwt.MapClaims); ok && token.Valid {
		username := claims["username"]
		role := claims["role"]
		fmt.Fprintf(w, "Welcome %v with role %v", username, role)
	} else {
		http.Error(w, "Invalid claims", http.StatusUnauthorized)
	}
}
// {/fact}
