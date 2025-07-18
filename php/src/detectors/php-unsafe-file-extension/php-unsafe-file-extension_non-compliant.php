<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-unsafe-file-extension@v1.0 defects=1}
function nonCompliant() {
    // Noncompliant: Writes a file with an unsafe extension `.pl`, which may allow code execution on some servers.
    $handle = fopen("uploads/" . "badfile.pl", "w");
    fclose($handle);
}

// {/fact}
?>
