// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package permissions

// {fact rule=go-poor-write-permissions@v1.0 defects=0}
import (
	"log"
	"os"
)

func setPermissionsCompliant() {
	// Compliant: Setting permissions to `0600` (read, write for owner only).
	err := os.Chmod("example.txt", 0600)
	if err != nil {
		log.Fatalf("Error setting permissions: %v", err)
	}
	log.Println("Permissions set to 0600 (compliant)")
}
// {/fact}
