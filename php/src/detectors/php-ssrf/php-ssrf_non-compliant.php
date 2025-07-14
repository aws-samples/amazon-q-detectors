<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-ssrf@v1.0 defects=1}
// Noncompliant: Directly uses unvalidated user input, potentially allowing Server-Side Request Forgery (SSRF) attacks.
function nonCompliant() {
    $curlHandle = curl_init($_GET['req']);
}
// {/fact}
?>
