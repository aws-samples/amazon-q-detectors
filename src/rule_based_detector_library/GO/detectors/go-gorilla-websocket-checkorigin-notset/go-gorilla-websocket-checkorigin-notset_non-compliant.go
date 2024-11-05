// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package origin

// {fact rule=go-gorilla-websocket-checkorigin-notset@v1.0 defects=1}
import (
	"github.com/gorilla/websocket"
	"log"
	"net/http"
)

func gorillaWebsocketCheckoriginNotsetNoncompliant(w http.ResponseWriter, r *http.Request) {
	var upgrader = websocket.Upgrader{}
	// Noncompliant: A `CheckOrigin` function is not used to validate the request origin.
	conn, err := upgrader.Upgrade(w, r, nil)
	if err != nil {
		log.Println(err)
		return
	}
	for {
		msgType, data, err := conn.ReadMessage()
		if err != nil {
			log.Println(err)
			return
		}
		if err := conn.WriteMessage(msgType, data); err != nil {
			log.Println(err)
			return
		}
	}
}
// {/fact}
