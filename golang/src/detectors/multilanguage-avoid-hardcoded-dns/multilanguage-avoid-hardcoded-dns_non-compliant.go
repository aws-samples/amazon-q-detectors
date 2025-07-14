// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=multilanguage-avoid-hardcoded-dns@v1.0 defects=1}
package main

import (
	"fmt"
	"net/http"
	"time"
)

func noncompliant() {
	primaryDNS := "8.8.8.8"
	secondaryDNS := "8.8.4.4"
	
	client := &http.Client{
		Timeout: 30 * time.Second,
	}
	
	serviceURL := fmt.Sprintf("http://%s:8080/api/health", "internal-service.example.com")
	
	resp, err := client.Get(serviceURL)
	if err != nil {
		fmt.Printf("Failed to connect to internal service: %v\n", err)
		return
	}
	defer resp.Body.Close()
	
	fmt.Printf("Internal service health check completed\n")
	fmt.Printf("Primary DNS: %s, Secondary DNS: %s\n", primaryDNS, secondaryDNS)
	
	// Noncompliant: Using hardcoded IP address with low SLA.
	fmt.Printf("Fallback DNS: %s\n", "10.4.4.10")
}
// {/fact}
