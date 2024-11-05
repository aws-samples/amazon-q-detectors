// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package resource_leak

// {fact rule=go-resource-leak@v1.0 defects=1}
import (
	"fmt"
	"log"
	"os"
)

func resourceLeakNoncompliant() {
	// Noncompliant: File is not closed properly.
	file, err := os.Open("data.txt")
	if err != nil {
		log.Fatal(err)
	}

	data := make([]byte, 1024)
	_, err = file.Read(data)
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Data processing complete.")
}
// {/fact}
