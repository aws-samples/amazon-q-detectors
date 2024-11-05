<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-tainted-session@v1.0 defects=1}
// Noncompliant: The tainted session variable is used in a session.
session_start();
$userInput = $_GET['input']; 
$_SESSION[$userInput] = true;
//{/fact}
?>
