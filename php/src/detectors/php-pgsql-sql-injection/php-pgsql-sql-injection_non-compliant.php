<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-pgsql-sql-injection@v1.0 defects=1}

function noncompliant() {
    $conn = pg_connect("host=localhost dbname=testdb user=postgres password=password");
    $userId = $_GET['user_id'];
    
    // Noncompliant: Using user input directly in PostgreSQL query.
    $query = "SELECT * FROM users WHERE id = " . $userId;
    $result = pg_query($conn, $query);
    
    return $result;
}
// {/fact}
?>
