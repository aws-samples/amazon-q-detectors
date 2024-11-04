/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package handler

// {fact rule=go-handler-assignment-from-multiple-sources@v1.0 defects=0}
import (
	"net/http"
)

type User struct {
	userId    string
	accountId string
}

func ValidateUser(userId string) bool {
	return true
}

func RetrieveUser(userId string) User {
	return User{userId, "0000"}
}

func handlerAssignmentFromMultipleSourcesCompliant(w http.ResponseWriter, r *http.Request) {
	// Compliant: `userId` is assigned from one source.
	userId := r.URL.Query().Get("user_id")

	if !ValidateUser(userId) {
		http.Error(w, "Error", http.StatusInternalServerError)
		return
	}

	userObj := RetrieveUser(userId)
	userObj.accountId = r.URL.Query().Get("account_id")
}
// {/fact}
