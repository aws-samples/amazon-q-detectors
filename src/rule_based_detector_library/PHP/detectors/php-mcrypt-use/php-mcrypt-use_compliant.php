<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-mcrypt-use@v1.0 defects=0}
// Compliant: `openssl_encrypt` function to perform encryption using the OpenSSL library.
openssl_encrypt($plainTextData, $encryptionMethod, $encryptionKey, $encryptionOptions = 0, $initializationVector, $authenticationTag);
// {/fact}
?>
