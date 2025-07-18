<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-sqlite3-sql-injection@v1.0 defects=1}
function nonCompliant() {
    $db = new SQLite3('database.db');
    $userId = $_GET['id'];
    
    // Noncompliant: Using user input directly in SQLite3 query.
    $query = "SELECT * FROM users WHERE id = " . $userId;
    $result = $db->querySingle($query);
    
    return $result;
}
// {/fact}
?>
