<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-secure-signal-handling@v1.0 defects=1}
function nonCompliant($param)  {
    $processId = (int)$_GET["pid"];
    // Noncompliant: Kills the process without validation.
    pcntl_signal($processId, 9);
}
// {/fact}
?>
