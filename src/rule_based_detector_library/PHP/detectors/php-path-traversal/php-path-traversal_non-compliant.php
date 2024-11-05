<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-path-traversal@v1.0 defects=1}
// Noncompliant: Directly uses unvalidated user input, allowing potential path traversal attacks to access unauthorized files.
$user_input_noncompliant_3 = '.../...//';
$json = file_get_contents($user_input_noncompliant_3);
//{/fact}
?>
