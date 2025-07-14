<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-backticks-use@v1.0 defects=1}

function getSystemInfo() {
    // Noncompliant: Using backticks for command execution.
    $result = `whoami`;
    return trim($result);
}
// {/fact}
?>
