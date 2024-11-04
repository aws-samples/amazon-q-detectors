/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package log_injection

// {fact rule=go-log-injection@v1.0 defects=1}
import (
	"log"
	"net/http"
)

func logInjectionNoncompliant(req *http.Request) {
	username := req.URL.Query()["username"][0]
	// Noncompliant: User provided input is passed directly to log.
	log.Printf("user %s logged in.\n", username)
}
// {/fact}
