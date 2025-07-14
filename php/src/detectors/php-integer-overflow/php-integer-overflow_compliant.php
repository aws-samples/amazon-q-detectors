<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-integer-overflow@v1.0 defects=0}

function compliant() {
    // Compliant: Using safe arithmetic with bounds checking.
    $value = 1000000;
    
    if ($value < PHP_INT_MAX - 1) {
        $result = $value + 1;
    } else {
        $result = PHP_INT_MAX;
    }
    
    return $result;
}
// {/fact}
?>
