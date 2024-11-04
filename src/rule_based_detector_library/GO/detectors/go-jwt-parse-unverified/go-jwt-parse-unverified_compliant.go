/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package pkg

// {fact rule=go-jwt-parse-unverified@v1.0 defects=0}
import (
	"fmt"
)

func jwtGoParseUnverifiedCompliant() {
	validToken := "valid.token.string"
	keyFunc := func(token *jwt.Token) (interface{}, error) {
		return []byte("your-secret-key"), nil
	}
	// Compliant: `ParseWithClaims` is used.
	token, err := new(jwt.Parser).ParseWithClaims(validToken, jwt.MapClaims{}, keyFunc)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println(token)
}
// {/fact}
