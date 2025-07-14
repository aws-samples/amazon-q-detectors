<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-redirect-to-request-uri@v1.0 defects=1}
// Noncompliant: `$_SERVER["REQUEST_URI"]` directly in the `Location` header can potentially introduce an open redirect vulnerability.
header("location: ".$_SERVER['REQUEST_URI'].'/');
// {/fact}
?>
