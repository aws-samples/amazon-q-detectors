<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-mysqli-sql-injection-ide@v1.0 defects=1}

function getUserById() {
    $userId = $_GET['id'];
    $mysqli = new mysqli("localhost", "user", "pass", "database");
    
    // Noncompliant: MySQLi SQL injection with user input.
    $query = "SELECT * FROM users WHERE id = " . $userId;
    $result = $mysqli->query($query);
    
    return $result->fetch_assoc();
}
// {/fact}
?>
