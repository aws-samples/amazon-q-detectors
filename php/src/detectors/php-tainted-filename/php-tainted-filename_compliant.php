<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-tainted-filename@v1.0 defects=0}
// Compliant: Uses tainted filename as the parameter in `hash_file()`, not as the filename, preventing potential path traversal attacks.
$taintedFilename = $_GET["tainted"];
hash_file($taintedFilename, 'test.txt');
// {/fact}
?>
