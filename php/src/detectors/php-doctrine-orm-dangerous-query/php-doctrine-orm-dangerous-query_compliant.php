<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-doctrine-orm-dangerous-query@v1.0 defects=0}
function compliant($userInput)
{
    $queryBuilder = $dbConnection->createQueryBuilder(); 
    $queryBuilder
        ->select('id', 'name')
        ->from('users')
        ->where('email = ?')
        // Compliant: Uses parameterized query to prevent SQL injection.
        ->setParameter(0, $userInput)
    ;
}
//{/fact}
?>
