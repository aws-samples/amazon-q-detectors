<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-doctrine-orm-dangerous-query@v1.0 defects=0}
// Compliant: Uses parameterized query to prevent SQL injection.
function executeCompliantQuery($userInput)
{
    $queryBuilder = $dbConnection->createQueryBuilder(); 
    $queryBuilder
        ->select('id', 'name')
        ->from('users')
        ->where('email = ?')
        ->setParameter(0, $userInput)
    ;
}
//{/fact}
?>
