<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-cookie-secure-set@v1.0 defects=0}

// Compliant: Cookie secure flag set to true ensures HTTPS-only transmission.
return [
    'driver' => env('SESSION_DRIVER', 'file'),
    'lifetime' => env('SESSION_LIFETIME', 120),
    'cookie' => env('SESSION_COOKIE', 'laravel_session'),
    'path' => '/',
    'domain' => env('SESSION_DOMAIN', null),
    'secure' => true,
    'http_only' => true,
    'same_site' => 'strict',
];
// {/fact}
?>
