<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-log-injection-ide@v1.0 defects=0}
function logUserActivity() {
    $username = $_GET['username'];
    $action = $_POST['action'];
    
    // Compliant: Sanitizing user input before logging.
    $sanitizedUsername = preg_replace('/[\r\n\t]/', '_', $username);
    $sanitizedAction = preg_replace('/[\r\n\t]/', '_', $action);
    
    error_log("User activity: " . $sanitizedUsername . " performed " . $sanitizedAction);
    file_put_contents('app.log', "Login attempt by: " . $sanitizedUsername . "\n", FILE_APPEND);
}
// {/fact}
?>
