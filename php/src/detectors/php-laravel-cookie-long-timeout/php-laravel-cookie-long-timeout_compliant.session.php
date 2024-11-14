<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-cookie-long-timeout@v1.0 defects=0}
function compliant(): ConfigRepository
{
    return new ConfigRepository([
        'session' => [
            // Compliant: Sets a short session `lifetime`, reducing the risk of unauthorized access through prolonged sessions.
            'lifetime' => 20,
            'files' => $this->paths->storage.'/sessions',
            'cookie' => 'session'
        ],
        'view' => [
            'paths' => [],
        ],
    ]);
}
// {/fact}
?>
