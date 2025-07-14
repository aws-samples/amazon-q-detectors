<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-ajax-no-auth-and-auth-hooks-audit@v1.0 defects=1}
// Noncompliant: Action hook for AJAX upload without proper authentication.
add_action('wp_ajax_upload', 'unauthorizedUpload');
// {/fact}
?>
