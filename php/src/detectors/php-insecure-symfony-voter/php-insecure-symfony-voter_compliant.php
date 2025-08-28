<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-insecure-symfony-voter@v1.0 defects=0}
function compliant() {
    $userInput = $_GET['input'];
    
    // Compliant: Compliant: Returns proper Voter constants instead of raw booleans.
    echo htmlspecialchars($userInput, ENT_QUOTES, 'UTF-8');
}
// {/fact}
?>
