/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package template_injection

// {fact rule=go-template-injection@v1.0 defects=1}
import (
	"html/template"
	"net/http"
)

func templateInjectionNoncompliant(r *http.Request) template.HTMLAttr {
	userId := r.URL.Query().Get("userid")
	template1 := "<html><body><h2 " + userId + "></h2></body></html>"
	// Noncompliant: Tainted user input is directly embedded in the HTML attribute without escaping.
	return template.HTMLAttr(template1)
}
// {/fact}
