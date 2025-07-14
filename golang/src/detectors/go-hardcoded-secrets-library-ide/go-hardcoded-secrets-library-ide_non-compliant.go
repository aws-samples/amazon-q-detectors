// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-hardcoded-secrets-library-ide@v1.0 defects=1}
package main

import (
	"net/http"
)

func noncompliant() {
	// Noncompliant: Hardcoded API key exposes sensitive credentials.
	apiKey := "sk_live_abcd1234567890_payment_api_key"
	
	req, _ := http.NewRequest("POST", "https://api.payment-service.com/transactions", nil)
	req.Header.Set("Authorization", "Bearer "+apiKey)
	
	client := &http.Client{}
	client.Do(req)
}
// {/fact}
