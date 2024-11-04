/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package insecuretemplate

// {fact rule=go-html-template-insecure-types@v1.0 defects=0}
import (
	"html/template"
	"log"
	"os"
)

func htmlTemplateInsecureTypesCompliant() {
	// Compliant: Insecure template is not used.
	t, err := template.New("tst").ParseFiles("example.txt")
	if err != nil {
		log.Println(err)
		return
	}
	t.Execute(os.Stdout, nil)
}
// {/fact}
