<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-unserialize-use@v1.0 defects=1}
function processUserData() {
    $userData = $_POST['data'];
    
    // Noncompliant: Uses `unserialize()` on untrusted input, which can lead to object injection vulnerabilities.
    $object = unserialize($userData);
    return $object;
}
// {/fact}
?>
