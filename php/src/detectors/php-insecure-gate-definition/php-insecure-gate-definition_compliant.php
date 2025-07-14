<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-insecure-gate-definition@v1.0 defects=0}

use Illuminate\Support\Facades\Gate;

function compliant() {
    // Compliant: Gate properly checks user permissions with conditional logic.
    Gate::define('edit-post', function ($user, $post) {
        if ($user->id === $post->user_id) {
            return true;
        }
        return false;
    });
}
// {/fact}
?>
