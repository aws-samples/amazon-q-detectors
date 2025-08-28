<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-log-injection@v1.0 defects=1}
function nonCompliant() {
    $username = $_POST['username'];
    $action = $_GET['action'];
    
    // Noncompliant: Logs untrusted user input directly without sanitization, leading to potential log injection.
    error_log("User " . $username . " performed action: " . $action);
    
    $logMessage = "Login attempt by: " . $username . "\n";
    file_put_contents('/var/log/app.log', $logMessage, FILE_APPEND);
}
// {/fact}
?>
