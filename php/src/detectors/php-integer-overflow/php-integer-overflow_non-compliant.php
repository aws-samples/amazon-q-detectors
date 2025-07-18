<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-integer-overflow@v1.0 defects=1}
function nonCompliant() {
    // Noncompliant: Integer overflow with large value addition.
    $value = 2147483648;
    $result = $value + 1;
    
    return $result;
}
// {/fact}
?>
