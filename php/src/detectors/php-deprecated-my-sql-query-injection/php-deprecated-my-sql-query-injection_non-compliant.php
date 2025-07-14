<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-deprecated-my-sql-query-injection@v1.0 defects=1}

function noncompliant() {
    $userId = $_GET['user_id'];
    $connection = mysql_connect('localhost', 'username', 'password');
    mysql_select_db('database', $connection);
    
    // Noncompliant: Using deprecated `mysql_query` with user input.
    $result = mysql_query("SELECT * FROM users WHERE id = $userId");
    
    return $result;
}
// {/fact}
?>
