
<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-php-object-injection-audit@v1.0 defects=0}
// Compliant: Only unserialize trusted and validated data to prevent potential security risks
$trustedData = 'O:1:"a":1:{s:5:"value";s:3:"100";}';
$object = unserialize($trustedData);
// {/fact}
?>
