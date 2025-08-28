<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-secure-signal-handling@v1.0 defects=0}
function compliant($param)  {
    $processId = (int)$_GET["pid"];
    // Compliant: Kills the process with validation.
    if (isValidPid($processId)) {
        pcntl_signal($processId, 9);
    }
}
// {/fact}
?>
