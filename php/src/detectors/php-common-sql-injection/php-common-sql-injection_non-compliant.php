<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-common-sql-injection@v1.0 defects=1}
function noncCompliant($database) {
    $user_id = $_GET['user_id'];
    $sql_query = "SELECT * FROM users WHERE id = $user_id";
    // Noncompliant: Direct use of user input in SQL query without sanitization can lead to SQL injection.
    return $database->query($sql_query);
}
// {/fact}
?>
