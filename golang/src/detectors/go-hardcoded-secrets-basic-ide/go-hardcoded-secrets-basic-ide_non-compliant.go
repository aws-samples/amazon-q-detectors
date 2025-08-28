// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-hardcoded-secrets-basic-ide@v1.0 defects=1}
package main

import (
	"fmt"
	"log"
)

func noncompliant() {
	dbHost := "localhost"
	dbPort := "5432"
	dbName := "production_db"
	dbUser := "admin"
	
	// Noncompliant: Hardcoded database password embedded directly in source code.
	dbPassword := "super_secret_db_password_123"
	
	connectionString := fmt.Sprintf("host=%s port=%s dbname=%s user=%s password=%s",
		dbHost, dbPort, dbName, dbUser, dbPassword)
	
	log.Printf("Attempting database connection with: %s", connectionString)
	
	fmt.Println("Database connection established successfully")
	fmt.Printf("Connected to %s database as user %s\n", dbName, dbUser)
}
// {/fact}
