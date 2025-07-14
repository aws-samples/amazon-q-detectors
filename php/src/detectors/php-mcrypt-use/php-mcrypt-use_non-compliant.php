<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-mcrypt-use@v1.0 defects=1}
// Noncompliant: `mcrypt_ecb` function to perform encryption using the ECB.
mcrypt_ecb(MCRYPT_BLOWFISH, $encryptionKey, base64_decode($inputData), MCRYPT_ENCRYPT);
// {/fact}
?>
