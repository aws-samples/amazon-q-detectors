<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-md5-loose-equality@v1.0 defects=1}
// Noncompliant: Used loose equality `==`.
$isMd5Match = md5("240610708") == "0";
// {/fact}
?>
