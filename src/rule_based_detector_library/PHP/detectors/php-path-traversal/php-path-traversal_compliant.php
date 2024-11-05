<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-path-traversal@v1.0 defects=0}
// Compliant: Uses `realpath()` to validate the final path, preventing directory traversal attacks by ensuring the expected path.
$user_input_compliant_3 = 'subdirectory/../file.txt';
$path = BASE_PATH . "/" . $user_input_compliant_3;
if(realpath($path) !== BASE_PATH . $user_input_compliant_3) {
  die("Invalid path");
}
$json = file_get_contents($path); 
//{/fact}
?>
