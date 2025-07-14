<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-pgsql-sql-injection-ide@v1.0 defects=0}

function getUserFromPostgres() {
    $userId = $_GET['id'];
    $connection = pg_connect("host=localhost dbname=test user=postgres password=pass");
    
    // Compliant: Using `pg_query_params` for safe parameterization.
    $query = "SELECT * FROM users WHERE id = $1";
    $result = pg_query_params($connection, $query, array($userId));
    
    return pg_fetch_assoc($result);
}
// {/fact}
?>
