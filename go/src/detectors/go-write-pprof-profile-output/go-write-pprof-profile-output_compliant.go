// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package profile

// {fact rule=go-write-pprof-profile-output@v1.0 defects=0}
import (
	"bytes"
	"errors"
	"net/http"
	"runtime/pprof"
)

type Token1 struct {
	HasDebugPermission bool
}

var ErrUnauthorizedAccess = errors.New("unauthorized access")

func checkPermissions(token Token1) bool {
	return token.HasDebugPermission
}

func writePprofProfileOutputCompliant(res http.ResponseWriter, req *http.Request, t Token1) error {
	if !checkPermissions(t) {
		return ErrUnauthorizedAccess
	}

	// Compliant: The profile is written to a buffer instead of directly to the response.
	var buf bytes.Buffer
	if err := pprof.Lookup("goroutine").WriteTo(&buf, 2); err != nil {
		return err
	}

	return nil
}
// {/fact}
