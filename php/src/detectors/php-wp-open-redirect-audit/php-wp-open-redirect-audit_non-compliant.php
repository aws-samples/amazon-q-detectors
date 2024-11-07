<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

//{fact rule=php-wp-open-redirect-audit@v1.0 defects=1}
function nonCompliant()
{
    $url = $_GET['url'];
    // Noncompliant: Uses `wp_redirect()` with unvalidated user input, potentially allowing open redirect vulnerabilities.
    wp_redirect($url);
    exit;
}
//{/fact}
?>
