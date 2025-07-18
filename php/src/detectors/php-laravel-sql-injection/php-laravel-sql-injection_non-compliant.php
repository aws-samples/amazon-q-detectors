<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-sql-injection@v1.0 defects=1}
use Illuminate\Support\Facades\DB;

function nonCompliant() {
    $userId = $_GET['id'];
    
    // Noncompliant: Using user input directly in unprepared query.
    DB::unprepared("SELECT * FROM users WHERE id = " . $userId);
}
// {/fact}
?>
