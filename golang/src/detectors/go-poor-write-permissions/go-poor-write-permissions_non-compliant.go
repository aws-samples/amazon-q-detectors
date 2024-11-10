// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package permissions

// {fact rule=go-poor-write-permissions@v1.0 defects=1}
import (
	"log"
	"os"
)

func setPermissionsNoncompliant() {
	// Noncompliant: Setting permissions to `0777` (read, write, execute for everyone).
	err := os.Chmod("example.txt", 0777)
	if err != nil {
		log.Fatalf("Error setting permissions: %v", err)
	}
	log.Println("Permissions set to 0777 (too permissive)")
}
// {/fact}
