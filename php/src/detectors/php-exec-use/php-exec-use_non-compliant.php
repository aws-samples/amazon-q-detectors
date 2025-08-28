<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-exec-use@v1.0 defects=1}
function nonCompliant($filename) {
    // Noncompliant: Using `exec()` function which can be dangerous.
    exec("ls -la " . $filename, $output);
    return $output;
}
// {/fact}
?>
