<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-path-traversal@v1.0 defects=1}
// Noncompliant: Demonstrates unsafe path handling that could lead to path traversal if used with user input.
$user_input_noncompliant = '.../...//';
$json = file_get_contents($user_input_noncompliant);
// {/fact}
?>
