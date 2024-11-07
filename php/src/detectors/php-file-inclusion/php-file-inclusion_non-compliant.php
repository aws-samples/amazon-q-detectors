<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-file-inclusion@v1.0 defects=1}
$unsafeUserInput = $_GET["tainted"];
// Noncompliant: `$unsafeUserInput` is not sanitized, leading to a potential file inclusion vulnerability.
include_once($unsafeUserInput); 
// {/fact}
?>
