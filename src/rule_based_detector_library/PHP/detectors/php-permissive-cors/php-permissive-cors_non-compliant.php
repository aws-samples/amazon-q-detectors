<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-permissive-cors@v1.0 defects=1}
// Noncompliant: `Access-Control-Allow-Origin` header to `*` can allow any origin to access sensitive resources without proper verification.
header('Access-Control-Allow-Origin: *');
// {/fact}

?>