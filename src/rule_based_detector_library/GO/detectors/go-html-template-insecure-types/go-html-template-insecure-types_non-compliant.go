/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package insecuretemplate

// {fact rule=go-html-template-insecure-types@v1.0 defects=1}
import (
	"html/template"
	"os"
)

func htmlTemplateInsecureTypesNoncompliant() {
	// Noncompliant: Insecure template is used.
	var s template.CSS = "body { background-color: lightblue; }"
	t, _ := template.New("insecure").Parse(string(s))
	t.Execute(os.Stdout, nil)
}
// {/fact}
