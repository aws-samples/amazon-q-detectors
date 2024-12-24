// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-no-sql-injection@v1.0 defects=0}
import csrf from 'csurf';
import cookieParser from 'cookie-parser';
import express, { Request, Response } from 'express';
import { MongoClient, Db } from 'mongodb';

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

const uri = "mongodb://localhost:27017";
const client = new MongoClient(uri);
let db: Db;

client.connect().then(() => {
    db = client.db("test");
    console.log("Connected to MongoDB");
}).catch(err => {
    console.error("Failed to connect to MongoDB", err);
});

function sanitize(input: unknown): string {
    if (typeof input !== 'string') {
        throw new Error('Invalid input: must be a string');
    }

    const sanitized = input.replace(/[^a-zA-Z0-9\-_.]/g, '');

    if (sanitized.length > 50) {
        throw new Error('Input is too long');
    }

    return sanitized;
}

app.get("/query", function (req: Request, res: Response) {
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
        if (error instanceof Error) {
            res.status(400).send(`Error: ${error.message}`);
        } else {
            res.status(400).send('An unknown error occurred');
        }
    }
});

const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
// {/fact}
