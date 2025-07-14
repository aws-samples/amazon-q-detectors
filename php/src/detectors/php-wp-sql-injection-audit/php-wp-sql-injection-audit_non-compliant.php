<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-sql-injection-audit@v1.0 defects=1}

function get_user_posts() {
    global $wpdb;
    
    // Noncompliant: Directly using unsanitized user input in SQL query leads to SQL injection vulnerability.
    $user_id = $_GET['user_id'];
    $results = $wpdb->get_results("SELECT * FROM wp_posts WHERE post_author = " . $user_id);
    
    return $results;
}
// {/fact}
?>
