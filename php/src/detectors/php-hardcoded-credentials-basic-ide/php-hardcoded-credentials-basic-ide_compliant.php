<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-hardcoded-credentials-basic-ide@v1.0 defects=0}
class DatabaseConnection {
    // Compliant: Reading credentials from environment variables.
    private $host;
    private $username;
    private $password;
    private $database;
    
    public function __construct() {
        $this->host = $_ENV['DB_HOST'] ?? 'localhost';
        $this->username = $_ENV['DB_USERNAME'];
        $this->password = $_ENV['DB_PASSWORD'];
        $this->database = $_ENV['DB_DATABASE'];
    }
    
    public function compliant() {
        return new mysqli($this->host, $this->username, $this->password, $this->database);
    }
}
// {/fact}
?>
