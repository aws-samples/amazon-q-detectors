<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

//{fact rule=php-openssl-decrypt-validate@v1.0 defects=1}
class OpenSslTest {
    public static function nonCompliant($ciphertext, $key) {
        $decodedKey = html_entity_decode($key);
        $iv = openssl_random_pseudo_bytes(16); 
        // Noncompliant: Incorrectly checks for `true` as the failure condition for `openssl_decrypt()`, potentially mishandling decryption failures.
        $decryptedData = openssl_decrypt($ciphertext, "AES-128-CBC", $decodedKey, 0, $iv);
        if ($decryptedData === true) {
            return "Decryption failed"; 
        }
        return $decryptedData;
    }
}
//{/fact}
?>