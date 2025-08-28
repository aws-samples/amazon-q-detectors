<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-log-injection@v1.0 defects=0}
function compliant() {
    $username = 'system_user';
    $action = 'automated_task';
    
    // Compliant: Using static values instead of user input.
    error_log("User " . $username . " performed action: " . $action);
    
    $logMessage = "System event: " . $action . " completed\n";
    file_put_contents('/var/log/app.log', $logMessage, FILE_APPEND);
}
// {/fact}
?>
