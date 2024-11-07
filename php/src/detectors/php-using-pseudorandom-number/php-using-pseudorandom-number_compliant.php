
<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-using-pseudorandom-number@v1.0 defects=0}
// Compliant: Securely generate random number.
$secureRandomNumber = random_bytes(16);
//{/fact}
?>
