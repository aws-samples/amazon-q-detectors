<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-file-inclusion@v1.0 defects=0}
// Compliant: Non-tainted input is passed to the function.
include_once('config_constants.php');
// {/fact}
?>
