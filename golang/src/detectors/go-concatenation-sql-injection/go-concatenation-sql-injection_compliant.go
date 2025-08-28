// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-concatenation-sql-injection@v1.0 defects=0}
package main

import (
	"database/sql"
	"strconv"

	"github.com/aws/aws-lambda-go/events"
	_ "github.com/go-sql-driver/mysql"
)

func compliant(request events.APIGatewayProxyRequest) {
	userIDStr := request.Body

	userID, err := strconv.Atoi(userIDStr)
	if err != nil {
		return
	}

	db, _ := sql.Open("mysql", "user:password@tcp(localhost:3306)/testdb")
	defer db.Close()

	// Compliant: Parameterized query prevents SQL injection.
	db.Query("SELECT * FROM users WHERE id = ?", userID)
}
// {/fact}
