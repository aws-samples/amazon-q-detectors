<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-ssrf@v1.0 defects=0}
// Compliant: Uses a hardcoded local file path, preventing Server-Side Request Forgery by not allowing user input to influence the file location.
function compliant() {
    $fileHandle = fopen("/tmp/test.txt", 'rb');
}
// {/fact}
?>
