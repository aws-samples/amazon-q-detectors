// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-hardcoded-security-sensitive-credentials@v1.0 defects=0}
import mysql from 'mysql';

function compliant(): void {
    // Compliant: Sensitive information is retrieved from environment variables.
    const connection = mysql.createConnection({
        host: process.env.URL,
        user: process.env.USERNAME,
        password: process.env.PASSWORD,
        database: process.env.DATABASE
    });
    connection.connect();
}
// {/fact}
