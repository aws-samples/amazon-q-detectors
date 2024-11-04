/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package jwt

// {fact rule=go-jwt-none-algorithm@v1.0 defects=0}
import (
	"fmt"
	"github.com/dgrijalva/jwt-go"
	"time"
)

func jwtGoNoneAlgorithmCompliant(key []byte) {
	claims := jwt.MapClaims{
		"sub":  "1234567890",
		"name": "Adam adams",
		"iat":  time.Now().Unix(),
	}

	// Compliant: `jwt.SigningMethodHS256` is used.
	token := jwt.NewWithClaims(jwt.SigningMethodHS256, claims)
	tokenString, err := token.SignedString(key)
	if err != nil {
		fmt.Println("Error signing token:", err)
		return
	}
	fmt.Println("JWT token:", tokenString)
}
// {/fact}
