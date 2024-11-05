<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-wp-open-redirect-audit@v1.0 defects=1}
// Noncompliant: Uses `wp_redirect()` with unvalidated user input, potentially allowing open redirect vulnerabilities.
function handleRedirect()
{
    $url = $_GET['url'];
    wp_redirect($url);
    exit;
}
//{/fact}
?>
