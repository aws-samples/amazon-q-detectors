<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-permissive-cors@v1.0 defects=0}
// Compliant: Custom header with a wildcard value does not pose a risk to cross-origin communication.
header("Other-Properties: *");
// {/fact}
?>
