<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-oracle-sql-injection-ide@v1.0 defects=0}

function getUserFromOracle() {
    $userId = $_GET['id'];
    $connection = oci_connect('user', 'pass', 'localhost/XE');
    
    // Compliant: Using bind variables with Oracle.
    $query = "SELECT * FROM users WHERE id = :id";
    $stmt = oci_parse($connection, $query);
    oci_bind_by_name($stmt, ':id', $userId);
    oci_execute($stmt);
    
    return oci_fetch_assoc($stmt);
}
// {/fact}
?>
