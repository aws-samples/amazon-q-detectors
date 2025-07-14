<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-tainted-sql-string@v1.0 defects=1}

function executeQuery() {
    $userInput = $_POST['query'];
    $pdo = new PDO('mysql:host=localhost;dbname=test', 'user', 'pass');
    
    // Noncompliant: Tainted SQL string from user input.
    $sql = "SELECT * FROM " . $userInput;
    $stmt = $pdo->query($sql);
    
    return $stmt->fetchAll();
}
// {/fact}
?>
