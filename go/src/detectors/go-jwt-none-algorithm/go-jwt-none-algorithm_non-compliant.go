// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package jwt

// {fact rule=go-jwt-none-algorithm@v1.0 defects=1}
import (
	"fmt"
	"github.com/dgrijalva/jwt-go"
	"time"
)

func jwtGoNoneAlgorithmNoncompliant() {
	claims := jwt.MapClaims{
		"sub":  "1234567890",
		"name": "Adam adams",
		"iat":  time.Now().Unix(),
	}

	// Noncompliant: `jwt.SigningMethodNone` is used.
	token := jwt.NewWithClaims(jwt.SigningMethodNone, claims)

	tokenString, err := token.SignedString(jwt.UnsafeAllowNoneSignatureType)
	if err != nil {
		fmt.Println("Error signing token:", err)
		return
	}
	fmt.Println("JWT token:", tokenString)
}
// {/fact}
