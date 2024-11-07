<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-sensitive-file-permission@v1.0 defects=0}
// Compliant: Used more restrictive file permissions `0750`.
setFilePermissionsCompliant("foo", 0750);
function setFilePermissionsCompliant($filePath, $permissions) {
    chmod($filePath, $permissions);
}
//{/fact}
?>
