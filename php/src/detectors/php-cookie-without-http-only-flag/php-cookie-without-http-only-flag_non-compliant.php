<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-cookie-without-http-only-flag@v1.0 defects=1}
$cookieDuration = $lifetime;
$cookieLocation = $path; 
$cookieSite = $domain;
// Noncompliant: `http-only` flag set to `false`.
session_set_cookie_params($cookieDuration, $cookieLocation, $cookieSite, true, false);
// {/fact}
?>
