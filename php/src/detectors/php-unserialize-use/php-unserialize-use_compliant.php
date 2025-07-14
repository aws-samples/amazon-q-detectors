<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-unserialize-use@v1.0 defects=0}

function processUserData() {
    $userData = $_POST['data'];
    
    // Compliant: Using JSON instead of `unserialize`.
    $object = json_decode($userData, true);
    return $object;
}
// {/fact}
?>
