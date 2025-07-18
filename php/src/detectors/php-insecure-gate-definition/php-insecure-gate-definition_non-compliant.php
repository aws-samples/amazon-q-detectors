<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-insecure-gate-definition@v1.0 defects=1}
use Illuminate\Support\Facades\Gate;

function nonCompliant() {
    // Noncompliant: Gate always returns `true`, granting access to all users.
    Gate::define('edit-post', function ($user) {
        return true;
    });
}
// {/fact}
?>
