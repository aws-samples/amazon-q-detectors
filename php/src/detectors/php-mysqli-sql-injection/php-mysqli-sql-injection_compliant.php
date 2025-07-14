<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-mysqli-sql-injection@v1.0 defects=0}

class UserRepository 
{
    private $mysqli;
    
    public function getUserById($userId) 
    {
       // Compliant: Prepared statements prevent SQL injection by separating code from data.
        $stmt = $this->mysqli->prepare("SELECT * FROM users WHERE id = ?");
        $stmt->bind_param("i", $userId);
        $stmt->execute();
        $result = $stmt->get_result();
        return $result->fetch_assoc();
    }

}
// {/fact}
?>
