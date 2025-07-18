<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-backticks-use@v1.0 defects=0}
function compliant() {
    // Compliant: Using PHP functions instead of shell commands.
    $result = get_current_user();
    return $result;
}
// {/fact}
?>
