<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-curl-ssl-verifypeer-off@v1.0 defects=0}
// Compliant: `CURLOPT_SSL_VERIFYPEER` is set to `true`.
$curlHandle = $ch; 
curl_setopt($curlHandle, CURLOPT_SSL_VERIFYPEER, true);
// {/fact}
?>
