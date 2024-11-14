<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-code-execution-audit@v1.0 defects=0}
// Compliant: Calls a safe function without executing arbitrary code.
safeFunction($args);
// {/fact}
?>
