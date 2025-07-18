<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-unrestricted-file-upload@v1.0 defects=1}
function nonCompliant() {
    if (isset($_FILES['upload'])) {
        $uploadedFile = $_FILES['upload'];
        $targetPath = 'uploads/' . $uploadedFile['name'];
        
        // Noncompliant: No file type validation or restrictions.
        move_uploaded_file($uploadedFile['tmp_name'], $targetPath);
        echo "File uploaded successfully!";
    }
}
// {/fact}
?>
