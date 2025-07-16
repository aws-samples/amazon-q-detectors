// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-no-sql-injection-ide@v1.0 defects=0}
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.http.ResponseEntity
import com.mongodb.MongoClient
import org.bson.Document

fun noSqlInjectionCompliant(@RequestParam username: String): ResponseEntity<Any> {
    val mongoClient = MongoClient("localhost", 27017)
    val database = mongoClient.getDatabase("testdb")
    val userCollection = database.getCollection("users")
    
    // Compliant: Using Document constructor with field-value pair prevents NoSQL injection.
    val query = Document("username", username)
    val result = userCollection.find(query).first()
    return ResponseEntity.ok(result)
}
// {/fact}
