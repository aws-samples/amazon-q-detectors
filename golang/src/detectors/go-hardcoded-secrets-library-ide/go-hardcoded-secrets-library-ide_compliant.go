// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-hardcoded-secrets-library-ide@v1.0 defects=0}
package main

import (
	"net/http"
	"os"
)

func compliant() {
	// Compliant: Environment variable prevents credential exposure.
	apiKey := os.Getenv("PAYMENT_API_KEY")
	if apiKey == "" {
		return
	}
	
	req, _ := http.NewRequest("POST", "https://api.payment-service.com/transactions", nil)
	req.Header.Set("Authorization", "Bearer "+apiKey)
	
	client := &http.Client{}
	client.Do(req)
}
// {/fact}
