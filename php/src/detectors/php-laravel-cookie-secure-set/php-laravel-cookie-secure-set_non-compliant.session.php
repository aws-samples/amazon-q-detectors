<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-cookie-secure-set@v1.0 defects=1}
return [
    'driver' => env('SESSION_DRIVER', 'file'),
    'lifetime' => env('SESSION_LIFETIME', 120),
    'expire_on_close' => false,
    'encrypt' => false,
    'files' => storage_path('framework/sessions'),
    'connection' => null,
    'store' => null,
    // Noncompliant: `secure` flag set to `false`, allowing cookies to be transmitted over insecure HTTP connections, risking data exposure.
    'cookie' => env(
        'SESSION_COOKIE',
        str_slug(env('APP_NAME', 'laravel'), '_').'_session'
    ),
    'path' => '/',
    'domain' => env('SESSION_DOMAIN', null),
    'secure' => false,
    'http_only' => true,
    'same_site' => 'lax',
];
// {/fact}
?>
