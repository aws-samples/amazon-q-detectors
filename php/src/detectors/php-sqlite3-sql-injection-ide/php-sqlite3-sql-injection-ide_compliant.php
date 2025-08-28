<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-sqlite3-sql-injection-ide@v1.0 defects=0}
function compliant() {
    $userId = $_GET['id'];
    $db = new SQLite3('database.db');
    
    // Compliant: Using prepared statements with `SQLite3`.
    $stmt = $db->prepare("SELECT * FROM users WHERE id = :id");
    $stmt->bindValue(':id', $userId, SQLITE3_INTEGER);
    $result = $stmt->execute();
    
    return $result->fetchArray();
}
// {/fact}
?>
