/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package handler

// {fact rule=go-handler-assignment-from-multiple-sources@v1.0 defects=1}
import (
	"net/http"

	"github.com/gorilla/sessions"
)

var store = sessions.NewCookieStore([]byte("blah-blah-blah"))

func handlerAssignmentFromMultipleSourcesNoncompliant(w http.ResponseWriter, r *http.Request) {
	session, _ := store.Get(r, "blah-session")
	userId := session.Values["user_id"].(string)

	if !ValidateUser(userId) {
		http.Error(w, "Error", http.StatusInternalServerError)
		return
	}
	// Noncompliant: `userId` is assigned from multiple sources.
	userId = r.URL.Query().Get("user_id")

	userObj := RetrieveUser(userId)
	userObj.accountId = r.URL.Query().Get("account_id")
}
// {/fact}
