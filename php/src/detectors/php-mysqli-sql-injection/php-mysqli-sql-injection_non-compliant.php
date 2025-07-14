<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-mysqli-sql-injection@v1.0 defects=1}

class UserRepository 
{
    private $mysqli;

    public function searchUsers() 
    {
        // Noncompliant: Concatenating untrusted input into SQL query makes it vulnerable to SQL injection.
        $searchTerm = $_POST['search'];
        $result = mysqli_query($this->mysqli, "SELECT * FROM users WHERE name LIKE '%" . $searchTerm . "%'");
        return mysqli_fetch_all($result);
    }
}
// {/fact}
?>
