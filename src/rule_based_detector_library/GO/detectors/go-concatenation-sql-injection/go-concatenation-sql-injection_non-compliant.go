/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package sql

// {fact rule=go-concatenation-sql-injection@v1.0 defects=1}
import (
	"database/sql"
	"net/http"
)

func concatenationSqlInjectionNoncompliant(database *sql.DB, request *http.Request) {
	// Noncompliant: Direct user input is used, risking SQL injection vulnerability.
	database.Exec("SELECT * FROM Users WHERE CityID=" + request.FormValue("cityId"))
}
// {/fact}
