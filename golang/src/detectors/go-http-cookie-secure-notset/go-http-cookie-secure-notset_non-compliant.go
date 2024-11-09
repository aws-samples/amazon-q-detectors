// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package util

// {fact rule=go-http-cookie-secure-notset@v1.0 defects=1}
import (
	"net/http"
)

func httpCookieSecureNotsetNoncompliant(w http.ResponseWriter, name, value string) {
	// Noncompliant: `Secure` not set.
	cookie := http.Cookie{
		HttpOnly: true,
		Name:     name,
		Value:    value,
	}
	http.SetCookie(w, &cookie)
}
// {/fact}
