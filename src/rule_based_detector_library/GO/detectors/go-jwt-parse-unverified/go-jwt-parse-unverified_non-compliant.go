/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package pkg

// {fact rule=go-jwt-parse-unverified@v1.0 defects=1}
import (
	"fmt"
)

func jwtGoParseUnverifiedNoncompliant() {
	validToken := "valid.token.string"
	// Noncompliant: `ParseUnverified` is used.
	token, _, err := new(jwt.Parser).ParseUnverified(validToken, jwt.MapClaims{})
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println(token)
}
// {/fact}
