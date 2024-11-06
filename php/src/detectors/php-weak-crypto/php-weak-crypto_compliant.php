<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-weak-crypto@v1.0 defects=0}
function compliant($value) {
    // Compliant: `SHA-256` is a secure hashing algorithm.
    $hashedPassword = hash('sha256', $value);
    $user->setPassword($hashedPassword);
}
// {/fact}
?>
