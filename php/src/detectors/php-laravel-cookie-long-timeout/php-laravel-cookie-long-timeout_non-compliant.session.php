<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

//{fact rule=php-laravel-cookie-long-timeout@v1.0 defects=1}
function nonCompliant(): ConfigRepository
{
    return new ConfigRepository([
        'session' => [
            // Noncompliant: Sets a long session `lifetime`, increasing the risk of unauthorized access through session hijacking.
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
