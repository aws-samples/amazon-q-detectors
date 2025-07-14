<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-open-redirect-audit@v1.0 defects=0}
function compliant()
{
    // Compliant: Uses `wp_safe_redirect()` to handle redirects, preventing open redirect vulnerabilities by validating the URL.
    wp_safe_redirect($_POST['url']);
    exit;
}
// {/fact}
?>
