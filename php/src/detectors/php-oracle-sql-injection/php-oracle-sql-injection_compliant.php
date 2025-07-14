<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-oracle-sql-injection@v1.0 defects=0}

class UserRepository 
{
    private $connection;
    
    public function getUserById($userId) 
    {
        // Compliant: Using parameterized query with bound variables.
        $sql = "SELECT * FROM users WHERE id = :user_id";
        $statement = oci_parse($this->connection, $sql);
        oci_bind_by_name($statement, ':user_id', $userId);
        oci_execute($statement);
        
        return oci_fetch_assoc($statement);
    }
}
// {/fact}
?>
