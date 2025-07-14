// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-concatenation-sql-injection@v1.0 defects=1}
package main

import (
	"database/sql"

	"github.com/aws/aws-lambda-go/events"
	_ "github.com/go-sql-driver/mysql"
)

func noncompliant(request events.APIGatewayProxyRequest) {
	userID := request.Body

	db, _ := sql.Open("mysql", "user:password@tcp(localhost:3306)/testdb")
	defer db.Close()

	query := "SELECT * FROM users WHERE id = " + userID
	// Noncompliant: String concatenation with user input enables SQL injection.
	db.Query(query)
}
// {/fact}
