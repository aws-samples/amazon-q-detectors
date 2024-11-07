<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-sensitive-file-permission@v1.0 defects=1}
$fileSystem = new Filesystem();
// Noncompliant: `0777` as it gives full read, write, and execute permissions to all users, which can be a security risk.
$fileSystem->chmod("foo", 0777);
//{/fact}
?>