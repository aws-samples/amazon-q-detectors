<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-ajax-no-auth-and-auth-hooks-audit@v1.0 defects=0}
// Compliant: Uses `plugins_loaded` hook, which runs for all requests, avoiding potential security issues with AJAX-specific hooks.
add_action('plugins_loaded', 'initializeUploadPlugins');
// {/fact}
?>
