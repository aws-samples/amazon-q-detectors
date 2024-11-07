<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-insecure-logging-config@v1.0 defects=1}
// Noncompliant: Sets a low maximum length for error logs, potentially truncating important security-related information.
ini_set('log_errors_max_length', '112'); 
// {/fact}
?>
