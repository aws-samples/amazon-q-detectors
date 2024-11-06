<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-md5-loose-equality@v1.0 defects=0}
// Compliant: Used type-safe comparison `===`.
$isMd5Match = md5("240610708") === "0";
//{/fact}
?>
