<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-openssl-cbc-static-iv@v1.0 defects=0}
function compliant($plaintext, $password) {
    $encryptionMethod = "AES-256-CBC";
    $encryptionKey = hash('sha256', $password, true);
    $initializationVector = openssl_random_pseudo_bytes(16);
    // Compliant: `$initializationVector` is used to initialize the cipher.
    $ciphertext = openssl_encrypt($plaintext, $encryptionMethod, $encryptionKey, OPENSSL_RAW_DATA, $initializationVector);
    $hash = hash_hmac('sha256', $ciphertext . $initializationVector, $encryptionKey, true);
    return $initializationVector . $hash . $ciphertext;
}
// {/fact}
?>
