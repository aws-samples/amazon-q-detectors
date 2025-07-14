<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-csrf-audit@v1.0 defects=0}
// Compliant: Uses `check_ajax_referer()` to verify the `nonce`, protecting against CSRF attacks in WordPress AJAX requests.
check_ajax_referer( 'wpforms-admin', 'nonce' );
// {/fact}
?>
