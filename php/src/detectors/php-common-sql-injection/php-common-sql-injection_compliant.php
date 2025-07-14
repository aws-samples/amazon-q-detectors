<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-common-sql-injection@v1.0 defects=0}

function getUserData() {
    $userId = $_GET['id'];
    $connection = new mysqli("localhost", "user", "pass", "database");
    
    // Compliant: Using prepared statements to prevent SQL injection.
    $stmt = $connection->prepare("SELECT * FROM users WHERE id = ?");
    $stmt->bind_param("i", $userId);
    $stmt->execute();
    $result = $stmt->get_result();
    
    return $result->fetch_assoc();
}
// {/fact}
?>
