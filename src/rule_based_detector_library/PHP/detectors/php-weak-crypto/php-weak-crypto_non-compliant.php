<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-weak-crypto@v1.0 defects=1}
// Noncompliant: Weak hashing algorithm `MD5` is used.
function setUserPasswordWeak($value) { 
    $hashedPassword = hash('md5', $value);
    $user->setPassword($hashedPassword);
}
// {/fact}
?>
