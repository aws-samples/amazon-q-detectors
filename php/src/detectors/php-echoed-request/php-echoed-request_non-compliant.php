<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-echoed-request@v1.0 defects=1}
function nonCompliant() { 
    $userInput = $_REQUEST['name'];
    // Noncompliant: `$userInput` statement is non-compliant as it can leave the application vulnerable to cross-site scripting attacks.
    echo "Hello: " . $userInput; 
}
// {/fact}
?>
