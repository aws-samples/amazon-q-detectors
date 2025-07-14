<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-unserialize-use@v1.0 defects=1}

function processUserData() {
    $userData = $_POST['data'];
    
    // Noncompliant: Using `unserialize()` on user input.
    $object = unserialize($userData);
    return $object;
}
// {/fact}
?>
