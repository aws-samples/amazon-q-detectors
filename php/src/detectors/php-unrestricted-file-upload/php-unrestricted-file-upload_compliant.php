<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-unrestricted-file-upload@v1.0 defects=0}

function uploadFile() {
    if (isset($_FILES['upload'])) {
        $uploadedFile = $_FILES['upload'];
        $allowedTypes = ['jpg', 'jpeg', 'png', 'gif'];
        $fileExtension = strtolower(pathinfo($uploadedFile['name'], PATHINFO_EXTENSION));
        $fileSize = $uploadedFile['size'];
        $maxFileSize = 5000000;
        
        // Compliant: Following the expected pattern with proper validation.
        if (!in_array($fileExtension, $allowedTypes)) {
            echo "Invalid file type!";
            return;
        }
        
        if ($fileSize > $maxFileSize) {
            echo "File too large!";
            return;
        }
        
        if (move_uploaded_file($uploadedFile['tmp_name'], 'uploads/' . uniqid() . '.' . $fileExtension)) {
            echo "File uploaded successfully!";
        } else {
            echo "Upload failed!";
        }
    }
}
// {/fact}
?>
