// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-no-sql-injection@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const { MongoClient } = require('mongodb');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

const uri = "mongodb://localhost:27017";
const client = new MongoClient(uri);
let db;

client.connect().then(() => {
    db = client.db("test");
    console.log("Connected to MongoDB");
}).catch(err => {
    console.error("Failed to connect to MongoDB", err);
});

function sanitize(input) {
    if (typeof input !== 'string') {
        throw new Error('Invalid input: must be a string');
    }

    const sanitized = input.replace(/[^a-zA-Z0-9\-_.]/g, '');

    if (sanitized.length > 50) {
        throw new Error('Input is too long');
    }

    return sanitized;
}

app.get("/query", function (req, res) {
    try {
        const query = {
            user: sanitize(req.query.user || ''),
            password: sanitize(req.query.password || '')
        };

        // Compliant: Sanitize user-provided data.
        db.collection("users").find(query).toArray((err, docs) => {
            if (err) {
                console.error("Database error:", err);
                res.status(500).send("Internal server error");
                return;
            }

            res.status(200).send(docs.length > 0 ? docs : "No matching users found");
        });
    } catch (error) {
        res.status(400).send(`Error: ${error.message}`);
    }
});

const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
// {/fact}

