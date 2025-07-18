<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-codeigniter-sql-injection-ide@v1.0 defects=1}
class UserController extends CI_Controller {
    
    public function nonCompliant() {
        $userId = $this->input->get('id');
        
        // Noncompliant: CodeIgniter SQL injection with direct query.
        $query = $this->db->query("SELECT * FROM users WHERE id = " . $userId);
        return $query->result();
    }

}
// {/fact}
?>

