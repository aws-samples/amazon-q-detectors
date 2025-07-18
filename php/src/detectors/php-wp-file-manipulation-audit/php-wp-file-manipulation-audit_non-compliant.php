<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-file-manipulation-audit@v1.0 defects=1}
function nonCompliant() {
    $filename = $_GET['file'];
    
    // Noncompliant: Using file manipulation function without validation.
    unlink($filename);
    
    return true;
}
// {/fact}
?>
