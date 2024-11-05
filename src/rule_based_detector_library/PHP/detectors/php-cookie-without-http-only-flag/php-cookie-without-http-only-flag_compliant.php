<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-cookie-without-http-only-flag@v1.0 defects=0}
// Compliant: `http-only` flag set to `true`.
$cookieLifetime = $lifetime;
$cookiePath = $path;
$cookieDomain = $domain;
session_set_cookie_params($cookieLifetime, $cookiePath, $cookieDomain, true, true); 
// {/fact}
?>