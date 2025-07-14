<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-unsafe-file-extension@v1.0 defects=0}

function compliant() {
    $allowed_extensions = ['mp4'];
    $ext = pathinfo("uploads/" . "video.mp4", PATHINFO_EXTENSION);
    // Compliant: Validating file extension before `include`.
    if (in_array($ext, $allowed_extensions)) {
        $handle = fopen("uploads/" . "video.mp4", "w");
        fclose($handle);
    } else {
        echo "Invalid file extension!";
    }
}
// {/fact}
?>
