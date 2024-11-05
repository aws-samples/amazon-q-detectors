// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package resource_leak

// {fact rule=go-resource-leak@v1.0 defects=0}
import (
	"fmt"
	"log"
	"os"
)

func resourceLeakCompliant() {
	// Compliant: File is closed properly.
	file, err := os.Open("data.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	data := make([]byte, 1024)
	_, err = file.Read(data)
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Data processing complete.")
}
// {/fact}
