<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-os-command-injection@v1.0 defects=0}
$fullpath = $_POST['fullpath'];
// Compliant: `escapeshellarg()` is used to prevent command injection.
$filesize = trim(shell_exec('stat -c %s ' . escapeshellarg($fullpath)));
//{/fact}
?>
