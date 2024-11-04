/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package sql

// {fact rule=go-concatenation-sql-injection@v1.0 defects=0}
import (
	"database/sql"
	"log"
	"net/http"
	"strconv"
)

func concatenationSqlInjectionCompliant(database *sql.DB, request *http.Request) {
	cityId := request.FormValue("cityId")

	// Compliant: Uses `strconv.Atoi` to validate input and prevent injection.
	if sanitizedCityID, err := strconv.Atoi(cityId); err == nil {
		database.Exec("SELECT * FROM Users WHERE CityID=?", sanitizedCityID)
	} else {
		log.Println("Invalid city ID provided:", err)
	}
}
// {/fact}
