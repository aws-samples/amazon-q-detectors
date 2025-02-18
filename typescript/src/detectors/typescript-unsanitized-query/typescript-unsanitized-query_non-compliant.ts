// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-unsanitized-query@v1.0 defects=1}
import express, { Request, Response } from 'express';
import config from './config';
import mysql, { Connection } from 'mysql';

const connection: Connection = mysql.createConnection({
    host: config.db.host,
    user: config.db.user,
    password: config.db.password,
    database: config.db.database,
});

connection.connect((err) => {
    if (err) {
        console.error('Error connecting to the database:', err);
        process.exit(1); // Exit the process if the connection fails
    }
    console.log('Connected to the database');
});

const app = express();

app.get("/someroute", (req: Request, res: Response) => {
    // Noncompliant: User input is directly concatenated into the SQL query without sanitization, risking SQL injection.
    const query = "SELECT * FROM SOMETHING WHERE ID = " + req.params.id;
    connection.query(query, (error, results, fields) => {
        if (error) throw error;
    });
});
// {/fact}
