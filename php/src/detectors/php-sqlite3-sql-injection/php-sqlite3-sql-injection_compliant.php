<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-sqlite3-sql-injection@v1.0 defects=0}

function compliant() {
    $db = new SQLite3('database.db');
    $userId = $_GET['id'];
    
    // Compliant: Using prepared statement with parameter binding.
    $query = "SELECT * FROM users WHERE id = ?";
    $stmt = $db->prepare($query);
    $stmt->bindValue(1, $userId, SQLITE3_INTEGER);
    $result = $stmt->execute();
    
    return $result;
}
// {/fact}
?>
