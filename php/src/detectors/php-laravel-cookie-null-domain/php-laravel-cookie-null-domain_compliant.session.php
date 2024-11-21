<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-cookie-null-domain@v1.0 defects=0}
$cookie_name = "test_cookie";
$cookie_value = "test_value";
$cookie_expiration = time(); 
$cookie_path = "/"; 
// Compliant: Sets a secure cookie with null domain, limiting its scope and enhancing security.
setcookie($cookie_name, $cookie_value, [
    'expires' => $cookie_expiration,
    'domain' => null,
    'secure' => true,
    'httponly' => true, 
]);
// {/fact}
?>
