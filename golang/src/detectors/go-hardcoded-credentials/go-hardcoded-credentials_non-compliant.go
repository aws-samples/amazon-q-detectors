// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-hardcoded-credentials@v1.0 defects=1}
package main

import (
	"database/sql"
	_ "github.com/go-sql-driver/mysql"
)

func noncompliant() {
	// Noncompliant: Hardcoded password exposes sensitive credentials.
	db, err := sql.Open("mysql", "user:mySecretPassword123@tcp(localhost:3306)/testdb")
	if err != nil {
		panic(err)
	}
	defer db.Close()
}
// {/fact}
