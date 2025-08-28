<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-codeigniter-sql-injection-ide@v1.0 defects=0}

class UserController extends CI_Controller {
    
    public function compliant() {
        $userId = $this->input->get('id');
        
        // Compliant: Using CodeIgniter's query binding.
        $query = $this->db->query("SELECT * FROM users WHERE id = ?", array($userId));
        return $query->result();
    }
}
// {/fact}
?>

