<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-sensitive-file-permission@v1.0 defects=0}
// Compliant: Used more restrictive file permissions `0750`.
compliant("foo", 0750);
function compliant($filePath, $permissions) {
    chmod($filePath, $permissions);
}
// {/fact}
?>
