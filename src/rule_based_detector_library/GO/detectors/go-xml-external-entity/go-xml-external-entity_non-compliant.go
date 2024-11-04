/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package xmlexternalentity

// {fact rule=go-xml-external-entity@v1.0 defects=1}
import (
	"fmt"
	"github.com/lestrrat-go/libxml2/parser"
)

func xmlExternalEntityNoncompliant() {
	const xmlData = "<!DOCTYPE d [<!ENTITY e SYSTEM \"file:///etc/passwd\">]><t>&e;</t>"
	// Noncompliant: The use of `XMLParseNoEnt` allows external entities.
	xmlParser := parser.New(parser.XMLParseNoEnt)
	parsedDoc, err := xmlParser.ParseString(xmlData)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println("XML document successfully parsed!")
	fmt.Println(parsedDoc)
}
// {/fact}
