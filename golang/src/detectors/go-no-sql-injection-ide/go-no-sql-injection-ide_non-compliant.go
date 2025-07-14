// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-no-sql-injection-ide@v1.0 defects=1}
package main

import (
	"context"
	"net/http"

	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
)

func noncompliant(w http.ResponseWriter, r *http.Request) {
	username := r.URL.Query().Get("username")
	
	client, _ := mongo.Connect(context.Background(), options.Client().ApplyURI("mongodb://localhost:27017"))
	defer client.Disconnect(context.Background())
	
	collection := client.Database("userdb").Collection("profiles")
	
	// Noncompliant: User input directly in MongoDB query enables NoSQL injection.
	filter := bson.M{"username": username}
	collection.FindOne(context.Background(), filter)
}
// {/fact}
