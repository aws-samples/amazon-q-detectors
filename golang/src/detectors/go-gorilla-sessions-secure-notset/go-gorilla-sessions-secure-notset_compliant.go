// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package session

// {fact rule=go-gorilla-sessions-secure-notset@v1.0 defects=0}
import (
	"github.com/gorilla/sessions"
	"net/http"
	"os"
)

func gorillaSessionsSecureNotsetCompliant(w http.ResponseWriter, r *http.Request) {
	var store = sessions.NewCookieStore([]byte(os.Getenv("SESSION_KEY")))
	session, _ := store.Get(r, "session-name")
	session.Options = &sessions.Options{
		Path:     "/",
		MaxAge:   60 * 60 * 24 * 365 * 5,
		HttpOnly: true,
		// Compliant: `Secure` flag is set to `true`.
		Secure: true,
	}

	session.Values["foo"] = "bar"
	err := session.Save(r, w)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
}
// {/fact}
