<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-sql-injection-audit@v1.0 defects=0}

function secureFunction() {
    $userInput = $_GET['input'];
    
    // Compliant: Encoding user input before output prevents injection attacks.
    echo htmlspecialchars($userInput, ENT_QUOTES, 'UTF-8');
}
// {/fact}
?>
