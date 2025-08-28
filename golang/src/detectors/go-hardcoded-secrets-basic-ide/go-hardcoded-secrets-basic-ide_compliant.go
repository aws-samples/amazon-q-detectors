// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-hardcoded-secrets-basic-ide@v1.0 defects=0}
package main

import (
	"fmt"
	"log"
	"os"
)

func compliant() {
	dbHost := "localhost"
	dbPort := "5432"
	dbName := "production_db"
	dbUser := "admin"
	
	// Compliant: Reading database password from environment variable.
	dbPassword := os.Getenv("DB_PASSWORD")
	if dbPassword == "" {
		log.Fatal("DB_PASSWORD environment variable is required")
	}
	
	connectionString := fmt.Sprintf("host=%s port=%s dbname=%s user=%s password=%s",
		dbHost, dbPort, dbName, dbUser, dbPassword)
	
	log.Printf("Attempting database connection to %s:%s/%s as %s", dbHost, dbPort, dbName, dbUser)
	
	fmt.Println("Database connection established successfully")
	fmt.Printf("Connected to %s database as user %s\n", dbName, dbUser)
}
// {/fact}
