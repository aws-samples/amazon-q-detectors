<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-log-injection-ide@v1.0 defects=1}
function logUserActivity() {
    $username = $_GET['username'];
    $action = $_POST['action'];
    
    // Noncompliant: Directly logging user input without sanitization.
    error_log("User activity: " . $username . " performed " . $action);
    file_put_contents('app.log', "Login attempt by: " . $username . "\n", FILE_APPEND);
}
// {/fact}
?>
