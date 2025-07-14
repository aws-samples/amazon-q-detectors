<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-sql-injection@v1.0 defects=0}

use Illuminate\Support\Facades\DB;

function compliant() {
    $userId = $_GET['id'];
    
    // Compliant: Using parameterized query with Laravel's query builder.
    DB::table('users')->where('id', $userId)->get();
}
// {/fact}
?>
