<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-pgsql-sql-injection@v1.0 defects=0}
function compliant() {
    $conn = pg_connect("host=localhost dbname=testdb user=postgres password=password");
    $userId = $_GET['user_id'];
    
    // Compliant: Using parameterized query with `pg_query_params`.
    $query = "SELECT * FROM users WHERE id = $1";
    $result = pg_query_params($conn, $query, array($userId));
    
    return $result;
}
// {/fact}
?>
