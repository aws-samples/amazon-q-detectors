<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-exec-use@v1.0 defects=0}

function processFile($filename) {
    // Compliant: Using safe file operations instead of `exec`.
    if (file_exists($filename)) {
        $fileInfo = stat($filename);
        return $fileInfo;
    }
    return null;
}
// {/fact}
?>
