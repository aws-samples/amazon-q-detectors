<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-pgsql-sql-injection-ide@v1.0 defects=1}

function getUserFromPostgres() {
    $userId = $_GET['id'];
    $connection = pg_connect("host=localhost dbname=test user=postgres password=pass");
    
    // Noncompliant: PostgreSQL SQL injection.
    $query = "SELECT * FROM users WHERE id = " . $userId;
    $result = pg_query($connection, $query);
    
    return pg_fetch_assoc($result);
}
// {/fact}
?>
