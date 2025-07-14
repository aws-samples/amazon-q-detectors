// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-avoid-alert-dialog@v1.0 defects=1}
package main

import "tawesoft.co.uk/go/dialog"

func noncompliant(username string) {
	if username != "" {
		// Noncompliant: Passing sensitive variable to alert dialog.
		dialog.Alert("Welcome back, ", username)
	} else {
		dialog.Alert("Please provide a username")
	}
}
// {/fact}
