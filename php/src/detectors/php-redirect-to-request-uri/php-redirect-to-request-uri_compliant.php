<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-redirect-to-request-uri@v1.0 defects=0}
// Compliant: Secure way to redirect users to the current script itself without opening up the possibility of an open redirect.
$currentScript = $_SERVER['PHP_SELF'];
header('Location: ' . $currentScript);
// {/fact}
?>
