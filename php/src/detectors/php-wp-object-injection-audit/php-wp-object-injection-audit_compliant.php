<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-object-injection-audit@v1.0 defects=0}
// Compliant: Unserializes only trusted, controlled data to avoid object injection risks.
$trustedData = 'O:1:"a":1:{s:5:"value";s:3:"100";}';
$object = unserialize($trustedData);
// {/fact}
?>
