// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-sql-injection-ide@v1.0 defects=1}
package main

import (
	"database/sql"
	"net/http"
	_ "github.com/lib/pq"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	username := r.URL.Query().Get("username")
	
	db, _ := sql.Open("postgres", "postgres://user:password@localhost/userdb")
	defer db.Close()
	
	// Noncompliant: String concatenation with user input enables SQL injection.
	query := "SELECT id, username FROM users WHERE username = '" + username + "'"
	rows, _ := db.Query(query)
	defer rows.Close()
}
// {/fact}
