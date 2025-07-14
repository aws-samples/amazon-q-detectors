<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-file-manipulation-audit@v1.0 defects=0}

function compliant() {
    $filename = $_GET['file'];
    
    // Compliant: Using file manipulation function with proper validation.
    if (is_valid_filename($filename)) {
        unlink($filename);
    }
    
    return true;
}

function is_valid_filename($filename) {
    return preg_match('/^[a-zA-Z0-9._-]+$/', $filename);
}
// {/fact}
?>
