<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-laravel-cookie-null-domain@v1.0 defects=1}
// Noncompliant: Sets a cookie with a specific domain, potentially allowing access from subdomains and increasing security risks.
$cookie_name = "test_cookie";
$cookie_value = "test_value";
$cookie_expiration = time();
$cookie_path = "/";
setcookie($cookie_name, $cookie_value, [
    'expires' => $cookie_expiration,
    'domain' => "baddomain.com",
    'secure' => true, 
]);
//{/fact}
?>
