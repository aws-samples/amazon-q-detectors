// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package xmlexternalentity

// {fact rule=go-xml-external-entity@v1.0 defects=0}
import (
	"fmt"
	"github.com/lestrrat-go/libxml2/parser"
)

func xmlExternalEntityCompliant() {
	const xmlData = "<!DOCTYPE d [<!ENTITY e SYSTEM \"file:///etc/passwd\">]><t>&e;</t>"
	// Compliant: External entity expansion is disabled by default.
	xmlParser := parser.New()
	parsedDoc, err := xmlParser.ParseString(xmlData)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println("XML document successfully parsed!")
	fmt.Println(parsedDoc)
}
// {/fact}
