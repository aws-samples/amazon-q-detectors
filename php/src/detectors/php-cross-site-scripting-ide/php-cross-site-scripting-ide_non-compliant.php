<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-cross-site-scripting-ide@v1.0 defects=1}

function displayUserInput() {
    $username = $_GET['username'];
    
    // Noncompliant: Direct output of user input without sanitization.
    echo "<div>Welcome, " . $username . "!</div>";
}
// {/fact}
?>
