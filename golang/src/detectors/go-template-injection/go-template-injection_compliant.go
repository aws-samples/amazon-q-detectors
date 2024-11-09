// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package template_injection

// {fact rule=go-template-injection@v1.0 defects=0}
import (
	"html/template"
	"net/http"
)

func templateInjectionCompliant(r *http.Request) template.HTMLAttr {
	userId := r.URL.Query().Get("userid")

	escapedUserId := template.HTMLEscapeString(userId)
	// Compliant: User input is escaped before being used in a template.
	template1 := "<html><body><h2 " + escapedUserId + "></h2></body></html>"
	return template.HTMLAttr(template1)
}
// {/fact}
