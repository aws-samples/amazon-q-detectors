<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-cross-site-scripting-ide@v1.0 defects=0}

function displayUserInput() {
    $username = $_GET['username'];
    
    // Compliant: Properly sanitizing user input before output.
    echo "<div>Welcome, " . htmlspecialchars($username, ENT_QUOTES, 'UTF-8') . "!</div>";
}
// {/fact}
?>
