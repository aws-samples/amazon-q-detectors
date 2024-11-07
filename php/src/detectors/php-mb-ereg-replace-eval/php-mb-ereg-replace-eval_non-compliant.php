<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

//{fact rule=php-mb-ereg-replace-eval@v1.0 defects=1}
// Noncompliant: Uses unvalidated user input directly in `mb_ereg()`, potentially allowing injection of malicious patterns or exploits.
$userInput = $_GET['pattern'];
mb_ereg($searchPattern, $inputString, $userInput); 
//{/fact}
?>
