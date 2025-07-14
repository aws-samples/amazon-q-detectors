<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-extract-user-data@v1.0 defects=1}
$unsafeFileData = $_FILES["/some/bad/path"];
// Noncompliant: `EXTR_PREFIX_SAME` is used to extract variables with the same name, which can lead to security issues.
extract($unsafeFileData, EXTR_PREFIX_SAME, "unsafePrefix");
// {/fact} 
?>
