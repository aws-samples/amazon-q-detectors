<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-zip-entry-check@v1.0 defects=1}
// Noncompliant: The entire content of the zip entry is read and returned by `zipEntryRead`.
$zip1 = new ZipArchive();
$zip1->extractTo('.');
// {/fact}
?>
