<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-avoid-exit-die@v1.0 defects=1}
// Noncompliant: `exit()` is used to terminate the script.
function nonCompliant($inputValue)  { 
    if ($inputValue === 42) {
        exit(23);
    }
}
// {/fact}
?>
