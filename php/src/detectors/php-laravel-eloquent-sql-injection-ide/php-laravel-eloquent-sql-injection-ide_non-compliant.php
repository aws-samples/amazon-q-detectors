<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-eloquent-sql-injection-ide@v1.0 defects=1}
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

function nonCompliant(Request $request) {
    $userInput = $request->input('search');
    
    // Noncompliant: Using user input directly in raw SQL query.
    $result = DB::raw("SELECT * FROM users WHERE name = '$userInput'");
    
    return $result;
}
// {/fact}
?>
