<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-extract-user-data@v1.0 defects=0}
// Compliant: `EXTR_SKIP` is used to skip the extraction of the variable.
$fileData = $_FILES["/some/bad/path"];
extract($fileData, EXTR_SKIP, "prefixVar");
// {/fact}     
?>
