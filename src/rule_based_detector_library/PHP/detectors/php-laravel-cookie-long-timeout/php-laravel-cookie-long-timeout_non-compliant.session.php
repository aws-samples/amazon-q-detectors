<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-laravel-cookie-long-timeout@v1.0 defects=1}
// Noncompliant: Sets a long session 'lifetime', increasing the risk of unauthorized access through session hijacking.
function getIlluminateConfig(): ConfigRepository
{
    return new ConfigRepository([
        'session' => [
            'lifetime' => 120,
            'files' => $this->paths->storage.'/sessions',
            'cookie' => 'session'
        ],
        'view' => [
            'paths' => [],
        ],
    ]);
}
//{/fact}
?>
