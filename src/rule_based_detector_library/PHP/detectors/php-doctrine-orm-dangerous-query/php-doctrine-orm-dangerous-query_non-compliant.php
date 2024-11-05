<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-doctrine-orm-dangerous-query@v1.0 defects=1}
// Noncompliant: Direct concatenation of user input in query, vulnerable to SQL injection.
function nonCompliant($unsafeInput) 
{
    $dbQueryBuilder = $dbConnection->createQueryBuilder();
    $dbQueryBuilder
        ->select('id', 'name')
        ->from('users')
        ->where('email = ' . $unsafeInput)
    ;
}
//{/fact}
?>
