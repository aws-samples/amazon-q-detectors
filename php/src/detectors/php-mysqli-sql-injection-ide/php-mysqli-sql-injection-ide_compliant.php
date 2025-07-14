<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-mysqli-sql-injection-ide@v1.0 defects=0}

function getUserById() {
    $userId = $_GET['id'];
    $mysqli = new mysqli("localhost", "user", "pass", "database");
    
    // Compliant: Using prepared statements.
    $stmt = $mysqli->prepare("SELECT * FROM users WHERE id = ?");
    $stmt->bind_param("i", $userId);
    $stmt->execute();
    $result = $stmt->get_result();
    
    return $result->fetch_assoc();
}
// {/fact}
?>
