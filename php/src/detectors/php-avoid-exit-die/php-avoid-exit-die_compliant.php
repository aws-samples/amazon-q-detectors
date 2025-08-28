<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-avoid-exit-die@v1.0 defects=0}
// Compliant: Exception thrown in a compliant way.
function compliant($inputValue)  { 
    if ($inputValue == 42) {
      throw new Exception('Value 42 is not expected.');
    }
}
// {/fact}
?>
