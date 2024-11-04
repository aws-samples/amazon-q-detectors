/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package profile

// {fact rule=go-write-pprof-profile-output@v1.0 defects=1}
import (
	"errors"
	"net/http"
	"runtime/pprof"
)

type Token struct {
	HasDebugPermission bool
}

var ErrUnauthorized = errors.New("unauthorized access")

func checkPermission(token Token) bool {
	return token.HasDebugPermission
}

func writePprofProfileOutputNoncompliant(res http.ResponseWriter, req *http.Request, t Token) error {
	if !checkPermission(t) {
		return ErrUnauthorized
	}

	// Noncompliant: The profile is written to the response, which could expose sensitive information.
	return pprof.Lookup("goroutine").WriteTo(res, 2)
}
// {/fact}
