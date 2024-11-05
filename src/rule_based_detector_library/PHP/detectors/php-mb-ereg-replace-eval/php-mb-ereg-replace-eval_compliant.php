<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-mb-ereg-replace-eval@v1.0 defects=0}
// Compliant: Uses `mb_eregi(`) function without the 'e' modifier, avoiding potential code execution vulnerabilities.
mb_eregi($searchPattern, $inputString, "safe-options");
//{/fact}
?>
