<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-tainted-session@v1.0 defects=0}
// Compliant: The session prefix is used to prevent tainted session input.
session_start();
$sessionPrefix = 'prefix'; 
$userInput = $_GET['input'];
$_SESSION[$sessionPrefix . $userInput] = true;
//{/fact}

?>
