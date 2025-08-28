<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-oracle-sql-injection-ide@v1.0 defects=1}
function nonCompliant() {
    $userId = $_GET['id'];
    $connection = oci_connect('user', 'pass', 'localhost/XE');
    
    // Noncompliant: Oracle SQL injection.
    $query = "SELECT * FROM users WHERE id = " . $userId;
    $stmt = oci_parse($connection, $query);
    oci_execute($stmt);
    
    return oci_fetch_assoc($stmt);
}
// {/fact}
?>
