<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-eloquent-sql-injection-ide@v1.0 defects=0}
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

function compliant(Request $request) {
    // Compliant: Using hardcoded values instead of user input.
    $result = DB::table('users')->where('name', 'john')->get();
    
    return $result;
}
// {/fact}
?>
