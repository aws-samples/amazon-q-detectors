<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-allow-url-fopen-or-include@v1.0 defects=1}
// Noncompliant: `allow_url_fopen` is set to `On`.
    ini_set('allow_url_fopen', 'On');
// {/fact}
?>
