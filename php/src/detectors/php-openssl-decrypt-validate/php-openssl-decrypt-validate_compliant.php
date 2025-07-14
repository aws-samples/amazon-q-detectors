<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-openssl-decrypt-validate@v1.0 defects=0}
class OpenSslTest {
    public static function compliant($ciphertext, $key) {
        $decodedKey = html_entity_decode($key);
        $iv = openssl_random_pseudo_bytes(16);
        // Compliant: Validates the result of `openssl_decrypt()` by checking for `false` return, ensuring proper handling of decryption failures.
        $decryptedData = openssl_decrypt($ciphertext, "AES-128-CBC", $decodedKey, 0, $iv);
        if ($decryptedData === false) {
            return "";
        }
        return $decryptedData;
    }
}
// {/fact}
?>
