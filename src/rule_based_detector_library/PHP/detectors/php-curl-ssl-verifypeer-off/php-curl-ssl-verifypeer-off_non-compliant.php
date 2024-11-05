<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-curl-ssl-verifypeer-off@v1.0 defects=1}
// Noncompliant: `CURLOPT_SSL_VERIFYPEER` is set to `false`.
$curlSession = $ch;
curl_setopt($curlSession, CURLOPT_SSL_VERIFYPEER, false);
// {/fact}
?>
