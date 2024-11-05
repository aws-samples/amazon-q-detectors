<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-wp-code-execution-audit@v1.0 defects=1}
// Noncompliant: Using `eval` to execute arbitrary code
$codeSnippet = call_user_func('return ' . $sanitizedSnippet . ';');

//{/fact}
?>
