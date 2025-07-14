<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-sqlite3-sql-injection-ide@v1.0 defects=1}

function getUserFromSQLite() {
    $userId = $_GET['id'];
    $db = new SQLite3('database.db');
    
    // Noncompliant: SQLite3 SQL injection.
    $query = "SELECT * FROM users WHERE id = " . $userId;
    $result = $db->query($query);
    
    return $result->fetchArray();
}
// {/fact}
?>
