<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-tainted-filename@v1.0 defects=1}
// Noncompliant: Uses unvalidated user input directly as a filename in `hash_file()`, potentially allowing path traversal attacks.
$taintedFilename = $_GET["tainted"];
hash_file('sha1', $taintedFilename);
// {/fact}
?>
