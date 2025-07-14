<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-hardcoded-credentials-basic-ide@v1.0 defects=1}

class DatabaseConnection {
    // Noncompliant: Hardcoded database credentials.
    private $host = "localhost";
    private $username = "admin";
    private $password = "secretPassword123";
    private $database = "myapp";
    
    public function connect() {
        return new mysqli($this->host, $this->username, $this->password, $this->database);
    }
}
// {/fact}
?>
