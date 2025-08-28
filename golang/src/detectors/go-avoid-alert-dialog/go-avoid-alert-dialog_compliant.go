// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-avoid-alert-dialog@v1.0 defects=0}
package main

import (
	"log"
	"tawesoft.co.uk/go/dialog"
)

func compliant(username string) {
	if username != "" {
		// Compliant: Using secure logging instead of exposing sensitive data in alert.
		log.Printf("User login successful for: %s", username)
		dialog.Alert("Welcome back!")
	} else {
		dialog.Alert("Please provide a username")
	}
}
// {/fact}
