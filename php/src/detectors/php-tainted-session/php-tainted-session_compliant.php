<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-tainted-session@v1.0 defects=0}
session_start();
$sessionPrefix = 'prefix'; 
$userInput = $_GET['input'];
// Compliant: The session prefix is used to prevent tainted session input.
$_SESSION[$sessionPrefix . $userInput] = true;
//{/fact}

?>
