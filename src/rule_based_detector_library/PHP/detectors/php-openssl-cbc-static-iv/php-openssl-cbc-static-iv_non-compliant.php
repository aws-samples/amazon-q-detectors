<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-openssl-cbc-static-iv@v1.0 defects=1}
function nonCompliant2($plaintext, $password) {
    $key = hash('sha256', $password, true);
    $iv = "4c25ecc95c8816db753cba44a3b56aca";
// Noncompliant : Hardcoded `vi` value in initialization vector.   
    $ciphertext = openssl_encrypt($plaintext, "AES-256-CBC", $key, OPENSSL_RAW_DATA, $iv);
    $hash = hash_hmac('sha256', $ciphertext . $iv, $key, true);
    return $iv . $hash . $ciphertext;
}
// {/fact}
?>