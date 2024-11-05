<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-laravel-cookie-long-timeout@v1.0 defects=0}
// Compliant: Sets a short session 'lifetime', reducing the risk of unauthorized access through prolonged sessions.
function getIlluminateConfig(): ConfigRepository
{
    return new ConfigRepository([
        'session' => [
            'lifetime' => 20,
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
