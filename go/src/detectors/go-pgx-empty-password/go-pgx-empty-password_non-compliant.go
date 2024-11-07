// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package dbsecurity

// {fact rule=go-pgx-empty-password@v1.0 defects=1}
import (
	"fmt"
	"net/http"

	"github.com/jackc/pgx"
)

func pgxEmptyPasswordNoncompliant(w http.ResponseWriter, req *http.Request) {
	configuration := pgx.ConnPoolConfig{
		ConnConfig: pgx.ConnConfig{
			Host:     "/run/postgresql",
			User:     "UserName12",
			Database: "MyDatabase",
			Password: "",
		},
		MaxConnections: 3,
	}
	// Noncompliant: Password in `pgx` connection config is empty.
	db, err := pgx.NewConnPool(configuration)
	if err != nil {
		fmt.Println("Error connecting to the database:", err)
		return
	}
	defer db.Close()
}
// {/fact}
