// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=multilanguage-avoid-hardcoded-dns@v1.0 defects=0}
package main

import (
	"fmt"
	"net/http"
	"os"
	"time"
)

func compliant() {
	primaryDNS := os.Getenv("PRIMARY_DNS")
	secondaryDNS := os.Getenv("SECONDARY_DNS")
	
	// Compliant: Using DNS hostname instead of hardcoded IP address.
	internalDNS := os.Getenv("INTERNAL_DNS_HOST")
	if internalDNS == "" {
		internalDNS = "internal-service.example.com"
	}
	
	client := &http.Client{
		Timeout: 30 * time.Second,
	}
	
	serviceURL := fmt.Sprintf("http://%s:8080/api/health", internalDNS)
	
	resp, err := client.Get(serviceURL)
	if err != nil {
		fmt.Printf("Failed to connect to internal service: %v\n", err)
		return
	}
	defer resp.Body.Close()
	
	fmt.Printf("Internal service health check completed\n")
	fmt.Printf("Primary DNS: %s, Secondary DNS: %s\n", primaryDNS, secondaryDNS)
	fmt.Printf("Internal DNS: %s (Status: %s)\n", internalDNS, resp.Status)
}
// {/fact}
