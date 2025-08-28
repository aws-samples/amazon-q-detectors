<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-tainted-sql-string@v1.0 defects=0}
function compliant() {
    $pdo = new PDO('mysql:host=localhost;dbname=test', 'user', 'pass');
    
    // Compliant: Using hardcoded SQL without user input.
    $sql = "SELECT * FROM users WHERE active = 1";
    $stmt = $pdo->query($sql);
    return $stmt->fetchAll();
}
// {/fact}
?>
