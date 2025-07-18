<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-deprecated-my-sql-query-injection@v1.0 defects=0}
function compliant() {
    $userId = $_GET['user_id'];
    $mysqli = new mysqli('localhost', 'username', 'password', 'database');
    
    // Compliant: Using `MySQLi` with prepared statement.
    $stmt = $mysqli->prepare("SELECT * FROM users WHERE id = ?");
    $stmt->bind_param("i", $userId);
    $stmt->execute();
    $result = $stmt->get_result();
    
    return $result;
}
// {/fact}
?>
