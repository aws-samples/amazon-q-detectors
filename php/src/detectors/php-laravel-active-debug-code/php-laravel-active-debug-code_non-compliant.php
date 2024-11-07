<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-active-debug-code@v1.0 defects=1}
// Noncompliant: Debug mode is enabled.
    config(['app.debug' => 'true']); 
// {/fact}
?>
