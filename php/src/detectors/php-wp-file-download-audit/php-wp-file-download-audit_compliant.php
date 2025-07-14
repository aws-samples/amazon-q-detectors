<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-file-download-audit@v1.0 defects=0}

function compliant() {
    $filename = $_GET['file'];
    
    // Compliant: Using database query instead of file operations.
    $content = get_user_data($filename);
    return $content;
}

function get_user_data($id) {
    return "User data for ID: " . $id;
}
// {/fact}
?>
