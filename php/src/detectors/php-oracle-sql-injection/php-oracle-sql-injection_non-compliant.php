<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-oracle-sql-injection@v1.0 defects=1}

class UserRepository 
{
    private $connection;
    
    public function getUserById($userId) 
    {
        // Noncompliant: Direct concatenation of user input.
        $sql = "SELECT * FROM users WHERE id = " . $_GET['id'];
        $statement = oci_parse($this->connection, $sql);
        oci_execute($statement);
        
        return oci_fetch_assoc($statement);
    }

}
// {/fact}
?>
