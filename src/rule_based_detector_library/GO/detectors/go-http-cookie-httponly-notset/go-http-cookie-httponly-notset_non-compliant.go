/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package util

// {fact rule=go-http-cookie-httponly-notset@v1.0 defects=1}
import (
	"net/http"
)

func httpCookieSecureNotsetNoncompliant(w http.ResponseWriter, name, value string) {
	// Noncompliant: `HttpOnly` not set.
	cookie := http.Cookie{
		Secure: true,
		Name:   name,
		Value:  value,
	}
	http.SetCookie(w, &cookie)
}
// {/fact}
