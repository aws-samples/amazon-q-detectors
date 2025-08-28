<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-no-sql-injection@v1.0 defects=1}
function nonCompliant() {
    $userId = $_GET['userId'];
    $manager = new MongoDB\Driver\Manager("mongodb://localhost:27017");
    
    // Noncompliant: NoSQL injection with user input.
    $filter = ['userId' => $userId];
    $query = new MongoDB\Driver\Query($filter);
    
    return $manager->executeQuery("mydb.users", $query);
}
// {/fact}
?>
