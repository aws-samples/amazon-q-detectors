<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-phpinfo-use@v1.0 defects=0}
// Compliant: Echoes a string instead of calling the `phpinfo()` function, avoiding exposure of sensitive system information.
echo "phpinfo";
//{/fact}
?>