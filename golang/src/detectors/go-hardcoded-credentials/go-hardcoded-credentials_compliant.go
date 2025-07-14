// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-hardcoded-credentials@v1.0 defects=0}
package main

import (
	"database/sql"
	"os"
	_ "github.com/go-sql-driver/mysql"
)

func compliant() {
	username := os.Getenv("DB_USERNAME")
	password := os.Getenv("DB_PASSWORD")
	host := os.Getenv("DB_HOST")
	dbname := os.Getenv("DB_NAME")

	// Compliant: Using environment variables prevents credential exposure.
	connectionString := username + ":" + password + "@tcp(" + host + ":3306)/" + dbname
	db, err := sql.Open("mysql", connectionString)
	if err != nil {
		panic(err)
	}
	defer db.Close()
}
// {/fact}
