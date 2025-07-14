<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-file-download-audit@v1.0 defects=1}

function noncompliant() {
    $filename = $_GET['file'];
    
    // Noncompliant: Using `file_get_contents` with user-controlled input.
    $content = file_get_contents($filename);
    return $content;
}
// {/fact}
?>
