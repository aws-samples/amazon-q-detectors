// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-hardcoded-security-sensitive-credentials@v1.0 defects=1}
import mysql from 'mysql';

function nonCompliant(): void {
    // Noncompliant: Hardcoded sensitive information in database connection.
    const connection = mysql.createConnection({
        host: "localhost",
        user: "admin",
        database: "db",
        password: "hardcoded_pass"
    });
    connection.connect();
}
// {/fact}
