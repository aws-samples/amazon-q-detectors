<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-weak-crypto@v1.0 defects=0}
// Compliant: `SHA-256` is a secure hashing algorithm.
function setUserPassword($value) {
    $hashedPassword = hash('sha256', $value);
    $user->setPassword($hashedPassword);
}
// {/fact}
?>
