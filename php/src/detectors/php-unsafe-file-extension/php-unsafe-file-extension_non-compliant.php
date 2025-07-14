<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-unsafe-file-extension@v1.0 defects=1}

function nonCompliant7() {
    // Noncompliant: Unsafe use of extension: .pl.
    $handle = fopen("uploads/" . "badfile.pl", "w");
    fclose($handle);
}

// {/fact}
?>
