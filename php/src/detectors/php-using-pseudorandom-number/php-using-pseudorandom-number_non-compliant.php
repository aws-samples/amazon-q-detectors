
<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-using-pseudorandom-number@v1.0 defects=1}
// Noncompliant: Insecure way of generating random number.
$insecureRandomNumber = mt_rand();
// {/fact}
?>
