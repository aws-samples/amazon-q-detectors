<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-phpinfo-use@v1.0 defects=1}

function showSystemInfo() {
    // Noncompliant: Using `phpinfo()` exposes sensitive system information.
    phpinfo();
}
// {/fact}
?>
